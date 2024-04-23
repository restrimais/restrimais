package com.lcdev.restrimais.rest.controller;

import com.lcdev.restrimais.rest.dto.assessment.AssessmentRevenueDTO;
import com.lcdev.restrimais.rest.dto.revenue.RevenueMinDTO;
import com.lcdev.restrimais.service.AssessmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/assements")
public class AssessmentController {

    private final AssessmentService assessmentService;

    @PutMapping
    public RevenueMinDTO saveAssement(@RequestBody AssessmentRevenueDTO dto){
        RevenueMinDTO revenueDTO = assessmentService.saveAssementRevenue(dto);
        return revenueDTO;
    }
}
