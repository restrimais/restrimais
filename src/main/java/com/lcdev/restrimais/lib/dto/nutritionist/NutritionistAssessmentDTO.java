package com.lcdev.restrimais.lib.dto.nutritionist;

import com.lcdev.restrimais.lib.entities.Nutritionist;
import com.lcdev.restrimais.lib.dto.assessment.NutritionistUserCommentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NutritionistAssessmentDTO {

    private Long id;
    private String name;
    private String crn;
    private String profileImg;
    private String specialization;
    private String biography;
    private Double score;
    private Integer count;
    private List<NutritionistUserCommentDTO> comments = new ArrayList<>();

    public NutritionistAssessmentDTO(Nutritionist entity){
        id = entity.getId();
        name = entity.getName();
        crn = entity.getCrn();
        specialization = entity.getSpecialization();
        biography = entity.getBiography();
        score = entity.getScore();
        count = entity.getCount();
        comments = entity.getAssessments().stream().map(NutritionistUserCommentDTO::new).collect(Collectors.toList());
    }

}
