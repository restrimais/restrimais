package com.lcdev.restrimais.rest.dto.steps;

import com.lcdev.restrimais.domain.entities.Step;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StepDTO {

    private Long id;
    private String step;

    public StepDTO (Step entity){
        id = entity.getId();
        step = entity.getStep();
    }
}
