package com.lcdev.restrimais.lib.dto.state;

import com.lcdev.restrimais.lib.entities.State;
import com.lcdev.restrimais.lib.dto.city.CityDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StateCityDTO {

    private Long id;
    private String name;
    private List<CityDTO> cities = new ArrayList<>();

    public StateCityDTO(State entity) {
        id = entity.getId();
        name = entity.getName();
        cities = entity.getCities().stream().map(CityDTO::new).collect(Collectors.toList());
    }
}
