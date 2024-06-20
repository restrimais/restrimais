package com.lcdev.restrimais.mapper.impl;

import com.lcdev.restrimais.domain.entities.Nutritionist;
import com.lcdev.restrimais.domain.entities.WorkSchedule;
import com.lcdev.restrimais.mapper.WorkScheduleMapper;
import com.lcdev.restrimais.rest.dto.consultation.WorkScheduleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WorkScheduleMapperImpl implements WorkScheduleMapper {
    @Override
    public WorkSchedule mapWorkSchedule(WorkScheduleDTO dto, Nutritionist nutritionist) {

        WorkSchedule entity = new WorkSchedule();

        entity.setNutritionist(nutritionist);
        entity.setDayOfWeek(dto.getDayOfWeek());
        entity.setEndTime(dto.getEndTime());
        entity.setStartTime(dto.getStartTime());

        return entity;
    }

}
