package com.lcdev.restrimais.mapper;

import com.lcdev.restrimais.lib.dto.assessment.AssessmentDTO;
import com.lcdev.restrimais.lib.entities.*;

public interface AssessmentMapper {

    AssessmentRevenue mapAssesssmentRevenue(AssessmentDTO dto, Patient patient, Revenue revenue);

    AssessmentNutritionist mapAssessmentNutritionist(AssessmentDTO dto, Patient patient, Nutritionist nutritionist);
}
