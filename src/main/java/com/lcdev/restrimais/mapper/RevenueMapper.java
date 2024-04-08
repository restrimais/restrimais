package com.lcdev.restrimais.mapper;

import com.lcdev.restrimais.domain.entities.Revenue;
import com.lcdev.restrimais.rest.dto.revenue.RevenueDTO;

public interface RevenueMapper {

    Revenue mapRevenue(RevenueDTO dto);
}
