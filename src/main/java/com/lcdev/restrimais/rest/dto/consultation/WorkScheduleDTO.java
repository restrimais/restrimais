package com.lcdev.restrimais.rest.dto.consultation;

import com.lcdev.restrimais.domain.entities.WorkSchedule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkScheduleDTO {

    private Long id;
    private Long nutritionistId;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;


    public WorkScheduleDTO(WorkSchedule entity){
        id = entity.getId();
        nutritionistId = entity.getNutritionist().getId();
        dayOfWeek = entity.getDayOfWeek();
        startTime = entity.getStartTime();
        endTime = entity.getEndTime();
    }

}
