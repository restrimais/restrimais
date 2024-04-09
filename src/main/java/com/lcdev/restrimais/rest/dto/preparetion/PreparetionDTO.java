package com.lcdev.restrimais.rest.dto.preparetion;

import com.lcdev.restrimais.domain.entities.Preparation;
import com.lcdev.restrimais.rest.dto.steps.StepDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PreparetionDTO {

    private Long id;
    private List<StepDTO> steps = new ArrayList<>();
    private String time;
    private String temperature;
    private String observation;

    public PreparetionDTO(Preparation entity){
        id = entity.getId();
        steps = entity.getSteps().stream().map(StepDTO::new).collect(Collectors.toList());
        time = entity.getTime();
        temperature = entity.getTemperature();
        observation = entity.getObservation();
    }

}
