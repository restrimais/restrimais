package com.lcdev.restrimais.lib.dto.assessment;

import com.lcdev.restrimais.lib.entities.AssessmentNutritionist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NutritionistUserCommentDTO {

    private String name;
    private String img;
    private String comment;

    public NutritionistUserCommentDTO(AssessmentNutritionist entity) {
        name = entity.getPatient().getName();
        img = entity.getPatient().getProfileImg();
        comment = entity.getComment();
    }
}
