package com.lcdev.restrimais.service;

import com.lcdev.restrimais.rest.dto.assessment.AssessmentRevenueDTO;
import com.lcdev.restrimais.rest.dto.revenue.RevenueDTO;
import com.lcdev.restrimais.rest.dto.revenue.RevenueMinDTO;

public interface AssessmentService {

    public RevenueMinDTO saveAssementRevenue(AssessmentRevenueDTO dto);
}
