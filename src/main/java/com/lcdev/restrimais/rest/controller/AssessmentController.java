package com.lcdev.restrimais.rest.controller;

import com.lcdev.restrimais.rest.dto.assessment.AssessmentDTO;
import com.lcdev.restrimais.rest.dto.revenue.RevenueMinDTO;
import com.lcdev.restrimais.service.AssessmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/assements")
public class AssessmentController {

    private final AssessmentService assessmentService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    @PutMapping
    public AssessmentDTO saveAssement(@RequestBody AssessmentDTO dto){
        AssessmentDTO assessmentDTO = assessmentService.saveAssessment(dto);
        return assessmentDTO;
    }
}
