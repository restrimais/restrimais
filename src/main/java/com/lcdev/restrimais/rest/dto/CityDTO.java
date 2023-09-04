package com.lcdev.restrimais.rest.dto;

import com.lcdev.restrimais.domain.entities.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityDTO {

    private Long id;
    private String name;
    private Long stateId;

    public CityDTO(City entity){
        id = entity.getId();
        name = entity.getName();
        stateId = entity.getState().getId();
    }
}
