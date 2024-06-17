package com.lcdev.restrimais.service.impl;

import com.lcdev.restrimais.domain.entities.*;
import com.lcdev.restrimais.repository.*;
import com.lcdev.restrimais.rest.dto.assessment.AssessmentDTO;
import com.lcdev.restrimais.service.AssessmentService;
import com.lcdev.restrimais.service.exceptions.InvalidAssessmentTypeException;
import com.lcdev.restrimais.service.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AssessmentServiceImpl implements AssessmentService {

    private final PatientRepository patientRepository;
    private final RevenueRepository revenueRepository;
    private final NutritionistRepository nutritionistRepository;
    private final AssessmentRevenueRepository assessmentRevenueRepository;
    private final AssessmentNutritionistRepository assessmentNutritionistRepository;

    @Override
    @Transactional
    public AssessmentDTO saveAssessment(AssessmentDTO dto) {

        Patient patient = patientRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado! Email: " + dto.getEmail()));

        switch (dto.getAssessmentType()) {
            case REVENUE:
                Revenue revenue = revenueRepository.findById(dto.getId())
                        .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado!"));

                AssessmentRevenue assessment = createAssessmentRevenue(dto, patient, revenue);
                assessmentRevenueRepository.saveAndFlush(assessment);
                updateRevenueScore(revenue);
                return new AssessmentDTO(assessment);
            case NUTRITIONIST:
                Nutritionist nutritionist = nutritionistRepository.findById(dto.getId())
                        .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado!"));

                AssessmentNutritionist assessmentNutritionist = createAssessmentNutritionist(dto, patient, nutritionist);
                assessmentNutritionistRepository.saveAndFlush(assessmentNutritionist);
                updateNutritionistScore(nutritionist);
                return new AssessmentDTO(assessmentNutritionist);
            default:
                throw new InvalidAssessmentTypeException("Tipo de enum desconhecido.");
        }
    }

    private AssessmentRevenue createAssessmentRevenue(AssessmentDTO dto, Patient patient, Revenue revenue) {
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

    private AssessmentNutritionist createAssessmentNutritionist(AssessmentDTO dto, Patient patient, Nutritionist nutritionist) {
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

    private void updateRevenueScore(Revenue revenue) {
        double sum = revenue.getAssessments().stream().mapToDouble(AssessmentRevenue::getValor).sum();
        double avg = sum / revenue.getAssessments().size();

        revenue.setScore(avg);
        revenue.setCount(revenue.getAssessments().size());

        revenueRepository.saveAndFlush(revenue);
    }

    private void updateNutritionistScore(Nutritionist nutritionist) {
        double sum = nutritionist.getAssessments().stream().mapToDouble(AssessmentNutritionist::getValor).sum();
        double avg = sum / nutritionist.getAssessments().size();

        nutritionist.setScore(avg);
        nutritionist.setCount(nutritionist.getAssessments().size());

        nutritionistRepository.saveAndFlush(nutritionist);
    }

}
