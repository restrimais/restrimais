package com.lcdev.restrimais.mapper;

import com.lcdev.restrimais.lib.dto.consultation.WorkScheduleDTO;
import com.lcdev.restrimais.lib.entities.Nutritionist;
import com.lcdev.restrimais.lib.entities.WorkSchedule;

public interface WorkScheduleMapper {

    WorkSchedule mapWorkSchedule(WorkScheduleDTO dto, Nutritionist nutritionist);

}
