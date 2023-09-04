package com.lcdev.restrimais.rest.dto.city;

import com.lcdev.restrimais.domain.entities.City;
import com.lcdev.restrimais.rest.dto.state.StateDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityStateDTO {

    private Long id;
    private String name;
    private StateDTO state;

    public CityStateDTO(City entity){
        id = entity.getId();
        name = entity.getName();
        state = new StateDTO(entity.getState());
    }
}
