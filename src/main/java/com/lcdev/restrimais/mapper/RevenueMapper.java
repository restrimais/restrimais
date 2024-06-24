package com.lcdev.restrimais.mapper;

import com.lcdev.restrimais.lib.entities.Revenue;
import com.lcdev.restrimais.lib.dto.revenue.RevenueDTO;

public interface RevenueMapper {

    Revenue mapRevenue(RevenueDTO dto);
}
