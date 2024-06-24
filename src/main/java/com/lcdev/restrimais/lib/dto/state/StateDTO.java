package com.lcdev.restrimais.lib.dto.state;

import com.lcdev.restrimais.lib.entities.State;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class StateDTO {

    private Long id;
    private String name;

    public StateDTO(State entity) {
        id = entity.getId();
        name = entity.getName();
    }
}
