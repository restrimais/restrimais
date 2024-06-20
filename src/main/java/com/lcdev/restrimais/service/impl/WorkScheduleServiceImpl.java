package com.lcdev.restrimais.service.impl;

import com.lcdev.restrimais.domain.entities.BlockedSlot;
import com.lcdev.restrimais.domain.entities.Nutritionist;
import com.lcdev.restrimais.domain.entities.Query;
import com.lcdev.restrimais.domain.entities.WorkSchedule;
import com.lcdev.restrimais.mapper.WorkScheduleMapper;
import com.lcdev.restrimais.repository.BlockedSlotRepository;
import com.lcdev.restrimais.repository.NutritionistRepository;
import com.lcdev.restrimais.repository.QueryRepository;
import com.lcdev.restrimais.repository.WorkScheduleRepository;
import com.lcdev.restrimais.rest.dto.consultation.WorkScheduleDTO;
import com.lcdev.restrimais.service.WorkScheduleService;
import com.lcdev.restrimais.service.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkScheduleServiceImpl implements WorkScheduleService {

    private final WorkScheduleRepository repository;

    private final NutritionistRepository nutritionistRepository;

    private final BlockedSlotRepository blockedSlotRepository;

    private final QueryRepository queryRepository;

    private final WorkScheduleMapper workScheduleMapper;


    @Override
    @Transactional
    public WorkScheduleDTO save(WorkScheduleDTO dto) {

        Nutritionist nutritionist = nutritionistRepository.findById(dto.getNutritionistId())
                .orElseThrow(() -> new ResourceNotFoundException("Nutricionista não encontrado!"));

        if(repository.existsByNutritionistIdAndDayOfWeekAndStartTimeAndEndTime(
                dto.getNutritionistId(), dto.getDayOfWeek(), dto.getStartTime(), dto.getEndTime())) {
            throw new IllegalArgumentException("Horarios e dia já existente.");
        }

        WorkSchedule entity = repository.save(workScheduleMapper.mapWorkSchedule(dto, nutritionist));
        return new WorkScheduleDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<LocalDateTime> generateAvailableSlots(Long nutritionistId, LocalDate startDate, LocalDate endDate) {
        List<WorkSchedule> schedules = repository.findByNutritionistId(nutritionistId);
        List<BlockedSlot> blockedSlots = blockedSlotRepository.findByNutritionistId(nutritionistId);
        List<Query> bookedQueries = queryRepository.findByNutritionistIdAndQueryDateBetween(
                nutritionistId, startDate.atStartOfDay(), endDate.atTime(LocalTime.MAX));

        List<LocalDateTime> availableSlots = new ArrayList<>();

        // Iterar sobre cada data no intervalo de datas
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            DayOfWeek dayOfWeek = date.getDayOfWeek();


            // Verificar os horários de trabalho para o dia da semana atual
            for (WorkSchedule schedule : schedules){
                if (schedule.getDayOfWeek() == dayOfWeek){
                    LocalDateTime slotStart = date.atTime(schedule.getStartTime());
                    LocalDateTime slotEnd = date.atTime(schedule.getEndTime());

                    // Gerar horários de consulta dentro do intervalo de trabalho
                    while (slotStart.isBefore(slotEnd)){
                        final LocalDateTime currentSlotStart = slotStart;

                        boolean isBlocked = blockedSlots.stream()
                                .anyMatch(bloked -> !currentSlotStart.isBefore(bloked.getBlockedStart()) && !currentSlotStart.isAfter(bloked.getBlockedStart()));
                        boolean isBooked = bookedQueries.stream()
                                .anyMatch(query -> query.getQueryDate().equals(currentSlotStart));

                        // Se o horário não está bloqueado e não tem consulta agendada, adicioná-lo à lista
                        if (!isBlocked && !isBooked){
                            availableSlots.add(currentSlotStart);
                        }

                        // Avançar para o próximo intervalo de 30 minutos
                        slotStart = slotStart.plusMinutes(30);
                    }
                }
            }
        }

        return availableSlots;
    }
}
