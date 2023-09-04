package com.lcdev.restrimais.rest.dto;

import com.lcdev.restrimais.domain.entities.State;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@ToString
public class StateCityDTO {

    private Long id;
    private String name;
    private List<CityDTO> cities = new ArrayList<>();

    public StateCityDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public StateCityDTO(State entity) {
        id = entity.getId();
        name = entity.getName();
        cities = entity.getCities().stream().map(CityDTO::new).collect(Collectors.toList());
    }
}
