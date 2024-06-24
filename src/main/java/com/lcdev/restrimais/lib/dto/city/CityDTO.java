package com.lcdev.restrimais.lib.dto.city;

import com.lcdev.restrimais.lib.entities.City;
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
