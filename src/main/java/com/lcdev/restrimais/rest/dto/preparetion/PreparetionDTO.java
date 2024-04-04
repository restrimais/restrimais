package com.lcdev.restrimais.rest.dto.preparetion;

import com.lcdev.restrimais.domain.entities.Preparation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PreparetionDTO {

    private Long id;
    private String step;
    private String time;
    private String temperature;
    private String observation;

    public PreparetionDTO(Preparation entity){
        id = entity.getId();
        step = entity.getStep();
        time = entity.getTime();
        temperature = entity.getTemperature();
        observation = entity.getObservation();
    }

}
