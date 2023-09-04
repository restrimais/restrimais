package com.lcdev.restrimais.rest.dto;

import com.lcdev.restrimais.domain.entities.State;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class StateDTO {

    private Long id;
    private String name;

    public StateDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public StateDTO(State entity) {
        id = entity.getId();
        name = entity.getName();
    }
}
