package com.lcdev.restrimais.rest.dto.assessment;

import com.lcdev.restrimais.domain.entities.Assessment;
import com.lcdev.restrimais.domain.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RevenueCommentsDTO {

    private String name;
    private String img;
    private String comment;

    public RevenueCommentsDTO(Assessment entity) {
        name = entity.getPatient().getName();
        img = entity.getPatient().getProfileImg();
        comment = entity.getComment();
    }
}
