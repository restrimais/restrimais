package com.lcdev.restrimais.lib.dto.steps;

import com.lcdev.restrimais.lib.entities.Step;
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
