package com.lcdev.restrimais.lib.dto.assessment;

import com.lcdev.restrimais.lib.entities.AssessmentRevenue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RevenueUserCommentDTO {

    private String name;
    private String img;
    private String comment;

    public RevenueUserCommentDTO(AssessmentRevenue entity) {
        name = entity.getPatient().getName();
        img = entity.getPatient().getProfileImg();
        comment = entity.getComment();
    }
}
