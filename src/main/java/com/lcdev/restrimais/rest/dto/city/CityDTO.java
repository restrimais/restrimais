package com.lcdev.restrimais.rest.dto.city;

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

    public CityDTO(City entity){
        id = entity.getId();
        name = entity.getName();
    }
}
