package com.lcdev.restrimais.service;

import com.lcdev.restrimais.lib.dto.consultation.WorkScheduleDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface WorkScheduleService {

    WorkScheduleDTO save(WorkScheduleDTO dto);

    List<LocalDateTime> generateAvailableSlots(Long nutritionistId, LocalDate startDate, LocalDate endDate);

}
