package com.lcdev.restrimais.mapper.impl;

import com.lcdev.restrimais.domain.entities.*;
import com.lcdev.restrimais.mapper.AssessmentMapper;
import com.lcdev.restrimais.rest.dto.assessment.AssessmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AssessmentMapperImpl implements AssessmentMapper {
    @Override
    public AssessmentRevenue mapAssesssmentRevenue(AssessmentDTO dto, Patient patient, Revenue revenue) {
        AssessmentRevenue assessment = new AssessmentRevenue();
        AssessmentRevenuePK assessmentPK = new AssessmentRevenuePK();
        assessmentPK.setPatientId(patient.getId());
        assessmentPK.setRevenueId(revenue.getId());
        assessment.setId(assessmentPK);
        assessment.setPatient(patient);
        assessment.setRevenue(revenue);
        assessment.setValor(dto.getScore());
        assessment.setComment(dto.getComment());
        return assessment;
    }

    @Override
    public AssessmentNutritionist mapAssessmentNutritionist(AssessmentDTO dto, Patient patient, Nutritionist nutritionist) {
        AssessmentNutritionist assessment = new AssessmentNutritionist();
        AssessmentNutritionistPK assessmentPK = new AssessmentNutritionistPK();
        assessmentPK.setPatientId(patient.getId());
        assessmentPK.setNutritionistId(nutritionist.getId());
        assessment.setId(assessmentPK);
        assessment.setPatient(patient);
        assessment.setNutritionist(nutritionist);
        assessment.setValor(dto.getScore());
        assessment.setComment(dto.getComment());
        return assessment;
    }
}
