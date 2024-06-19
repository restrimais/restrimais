package com.lcdev.restrimais.service.impl;

import com.lcdev.restrimais.domain.entities.Nutritionist;
import com.lcdev.restrimais.domain.entities.Patient;
import com.lcdev.restrimais.domain.entities.Query;
import com.lcdev.restrimais.repository.*;
import com.lcdev.restrimais.rest.dto.consultation.QueryDTO;
import com.lcdev.restrimais.service.QueryService;
import com.lcdev.restrimais.service.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class QueryServiceImpl implements QueryService {

    private final QueryRepository repository;
    private final PatientRepository patientRepository;
    private final NutritionistRepository nutritionistRepository;
    private final WorkScheduleRepository workScheduleRepository;
    private final BlockedSlotRepository blockedSlotRepository;

    @Override
    @Transactional
    public QueryDTO save(QueryDTO dto) {

        Patient patient = patientRepository.findById(dto.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado! Id: " + dto.getPatientId()));

        Nutritionist nutritionist = nutritionistRepository.findById(dto.getNutritionistId())
                .orElseThrow(() -> new ResourceNotFoundException("Nutricionista não encontrado! Id: " + dto.getNutritionistId()));

        LocalDateTime queryDate = dto.getQueryDate();
        boolean isWithinWorkHours = workScheduleRepository.findByNutritionistIdAndDayOfWeek(
                nutritionist.getId(), queryDate.getDayOfWeek()).stream().anyMatch(
                        schedule -> queryDate.toLocalTime().isAfter(
                                schedule.getStartTime()) && queryDate.toLocalTime().isBefore(schedule.getEndTime()));
        if (!isWithinWorkHours){
            throw new IllegalArgumentException("O horário solicitado está fora do horário de trabalho do nutricionista.");
        }

        boolean isBlocked = blockedSlotRepository.findByNutritionistId(nutritionist.getId()).stream()
                .anyMatch(blocked -> !queryDate.isBefore(blocked.getBlockedStart()) && !queryDate.isAfter(blocked.getBlockedEnd()));

        if (!isBlocked){
            throw new IllegalArgumentException("O horário solicitado está bloqueado.");
        }

        boolean isBooked = repository.findByNutritionistIdAndQueryDateBetween(nutritionist.getId(), queryDate.minusMinutes(30), queryDate.plusMinutes(30)).isEmpty();

        if (!isBooked) {
            throw new IllegalArgumentException("O horário solicitado já está reservado.");
        }

        Query entity = new Query();
        entity.setPatient(patient);
        entity.setNutritionist(nutritionist);
        entity.setQueryDate(queryDate);
        entity.setStatus(dto.getStatus());
        entity.setObservation(dto.getObservation());
        entity.setPrice(dto.getPrice());

        entity = repository.save(entity);

        return new QueryDTO(entity);
    }
}
