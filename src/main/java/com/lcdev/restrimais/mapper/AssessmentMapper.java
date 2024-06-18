package com.lcdev.restrimais.mapper;

import com.lcdev.restrimais.domain.entities.*;
import com.lcdev.restrimais.rest.dto.assessment.AssessmentDTO;

public interface AssessmentMapper {

    AssessmentRevenue mapAssesssmentRevenue(AssessmentDTO dto, Patient patient, Revenue revenue);

    AssessmentNutritionist mapAssessmentNutritionist(AssessmentDTO dto, Patient patient, Nutritionist nutritionist);
}
