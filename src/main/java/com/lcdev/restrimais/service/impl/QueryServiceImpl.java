package com.lcdev.restrimais.service.impl;

import com.lcdev.restrimais.lib.entities.Nutritionist;
import com.lcdev.restrimais.lib.entities.Patient;
import com.lcdev.restrimais.lib.entities.Query;
import com.lcdev.restrimais.lib.enums.QueryStatus;
import com.lcdev.restrimais.mapper.QueryMapper;
import com.lcdev.restrimais.repository.*;
import com.lcdev.restrimais.lib.dto.consultation.QueryDTO;
import com.lcdev.restrimais.service.QueryService;
import com.lcdev.restrimais.service.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QueryServiceImpl implements QueryService {

    private final QueryRepository repository;

    private final PatientRepository patientRepository;

    private final NutritionistRepository nutritionistRepository;

    private final WorkScheduleRepository workScheduleRepository;

    private final BlockedSlotRepository blockedSlotRepository;

    private final QueryMapper queryMapper;

    @Override
    @Transactional
    public QueryDTO save(QueryDTO dto) {

        Patient patient = patientRepository.findById(dto.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado! Id: " + dto.getPatientId()));

        Nutritionist nutritionist = nutritionistRepository.findById(dto.getNutritionistId())
                .orElseThrow(() -> new ResourceNotFoundException("Nutricionista não encontrado! Id: " + dto.getNutritionistId()));

        validateQueryDate(dto);

        Query entity = repository.save(queryMapper.mapQuery(dto, patient, nutritionist));
        return new QueryDTO(entity);
    }

    private void validateQueryDate(QueryDTO dto){

        boolean isWithinWorkHours = workScheduleRepository.findByNutritionistIdAndDayOfWeek(
                dto.getNutritionistId(), dto.getQueryDate().getDayOfWeek()).stream().anyMatch(
                schedule -> dto.getQueryDate().toLocalTime().isAfter(
                        schedule.getStartTime()) && dto.getQueryDate().toLocalTime().isBefore(schedule.getEndTime()));

        if (!isWithinWorkHours){
            throw new IllegalArgumentException("O horário solicitado está fora do horário de trabalho do nutricionista.");
        }

        boolean isBlocked = blockedSlotRepository.findByNutritionistId(dto.getNutritionistId()).stream()
                .anyMatch(blocked -> dto.getQueryDate().isBefore(
                        blocked.getBlockedStart()) && dto.getQueryDate().isAfter(blocked.getBlockedEnd()));

        if (isBlocked){
            throw new IllegalArgumentException("O horário solicitado está bloqueado.");
        }

        boolean isBooked = repository.findByNutritionistIdAndQueryDateBetweenAndStatus(
                dto.getNutritionistId(), dto.getQueryDate().minusMinutes(30), dto.getQueryDate().plusMinutes(30), QueryStatus.BOOKED).isEmpty();

        if (!isBooked) {
            throw new IllegalArgumentException("O horário solicitado já está reservado.");
        }

    }
}
