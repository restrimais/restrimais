package com.lcdev.restrimais.mapper;

import com.lcdev.restrimais.domain.entities.Nutritionist;
import com.lcdev.restrimais.domain.entities.Patient;
import com.lcdev.restrimais.domain.entities.Query;
import com.lcdev.restrimais.domain.entities.WorkSchedule;
import com.lcdev.restrimais.rest.dto.consultation.WorkScheduleDTO;

public interface WorkScheduleMapper {

    WorkSchedule mapWorkSchedule(WorkScheduleDTO dto, Nutritionist nutritionist);

}
