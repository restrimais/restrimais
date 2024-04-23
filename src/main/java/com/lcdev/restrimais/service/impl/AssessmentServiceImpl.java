package com.lcdev.restrimais.service.impl;

import com.lcdev.restrimais.domain.entities.Assessment;
import com.lcdev.restrimais.domain.entities.AssessmentRevenuePK;
import com.lcdev.restrimais.domain.entities.Patient;
import com.lcdev.restrimais.domain.entities.Revenue;
import com.lcdev.restrimais.repository.AssessmentRepository;
import com.lcdev.restrimais.repository.PatientRepository;
import com.lcdev.restrimais.repository.RevenueRepository;
import com.lcdev.restrimais.rest.dto.assessment.AssessmentRevenueDTO;
import com.lcdev.restrimais.rest.dto.revenue.RevenueDTO;
import com.lcdev.restrimais.rest.dto.revenue.RevenueMinDTO;
import com.lcdev.restrimais.service.AssessmentService;
import com.lcdev.restrimais.service.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AssessmentServiceImpl implements AssessmentService {

    private final PatientRepository patientRepository;
    private final RevenueRepository revenueRepository;
    private final AssessmentRepository assessmentRepository;

    @Override
    @Transactional
    public RevenueMinDTO saveAssementRevenue(AssessmentRevenueDTO dto) {

        Patient patient = patientRepository.findByEmail(dto.getEmail());
        if(patient == null) {
            patient = new Patient();
            patient.setEmail(dto.getEmail());
            patient = patientRepository.saveAndFlush(patient);
        }

        Revenue revenue = revenueRepository.findById(dto.getIdRevenue()).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado!"));

        Assessment assessment = new Assessment();
        AssessmentRevenuePK assessmentPK = new AssessmentRevenuePK();
        assessmentPK.setPatientId(patient.getId());
        assessmentPK.setRevenueId(revenue.getId());
        assessment.setId(assessmentPK);

        assessment.setPatient(patient);
        assessment.setRevenue(revenue);
        assessment.setValor(dto.getScore());
        assessment.setComment(dto.getComment());

        assessmentRepository.saveAndFlush(assessment);

        assessmentRepository.saveAndFlush(assessment);

        updateRevenueScore(revenue);

        return new RevenueMinDTO(revenue);
    }

    private void updateRevenueScore(Revenue revenue) {
        double sum = revenue.getAssessments().stream().mapToDouble(Assessment::getValor).sum();
        double avg = sum / revenue.getAssessments().size();

        revenue.setScore(avg);
        revenue.setCount(revenue.getAssessments().size());

        revenueRepository.saveAndFlush(revenue);
    }

}
