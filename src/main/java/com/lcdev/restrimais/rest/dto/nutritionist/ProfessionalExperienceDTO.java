package com.lcdev.restrimais.rest.dto.nutritionist;

import com.lcdev.restrimais.domain.entities.ProfessionalExperience;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionalExperienceDTO {

    private Long id;
    private String office;
    private String company;
    private LocalDate startDate;
    private LocalDate endDate;
    private NutritionistDTO nutritionist;

    public ProfessionalExperienceDTO(ProfessionalExperience entity){
        id = entity.getId();
        office = entity.getOffice();
        company = entity.getCompany();
        startDate = entity.getStartDate();
        endDate = entity.getEndDate();
        nutritionist = new NutritionistDTO(entity.getNutritionist());
    }

}
