package com.lcdev.restrimais.lib.dto.assessment;

import com.lcdev.restrimais.lib.entities.AssessmentNutritionist;
import com.lcdev.restrimais.lib.entities.AssessmentRevenue;
import com.lcdev.restrimais.lib.enums.AssessmentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssessmentDTO {

    private Long id;
    private Double score;
    private String comment;
    private String email;
    private AssessmentType assessmentType;

    public AssessmentDTO(AssessmentRevenue assessment) {
        id = assessment.getId().getPatientId();
        score = assessment.getValor();
        comment = assessment.getComment();
        email = assessment.getPatient().getEmail();
    }

    public AssessmentDTO(AssessmentNutritionist assessment) {
        id = assessment.getId().getNutritionistId();
        score = assessment.getValor();
        comment = assessment.getComment();
        email = assessment.getPatient().getEmail();
    }
}
