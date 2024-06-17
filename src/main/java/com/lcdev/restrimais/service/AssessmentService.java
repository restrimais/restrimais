package com.lcdev.restrimais.service;

import com.lcdev.restrimais.domain.enums.AssessmentType;
import com.lcdev.restrimais.rest.dto.assessment.AssessmentDTO;
import com.lcdev.restrimais.rest.dto.revenue.RevenueMinDTO;

public interface AssessmentService {

    AssessmentDTO saveAssessment(AssessmentDTO dto);
}
