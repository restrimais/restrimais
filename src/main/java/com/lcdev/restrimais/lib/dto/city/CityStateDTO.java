package com.lcdev.restrimais.lib.dto.city;

import com.lcdev.restrimais.lib.dto.state.StateDTO;
import com.lcdev.restrimais.lib.entities.City;
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
