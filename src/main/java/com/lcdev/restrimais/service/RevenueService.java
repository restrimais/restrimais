package com.lcdev.restrimais.service;

import com.lcdev.restrimais.lib.dto.revenue.RevenueDTO;
import com.lcdev.restrimais.lib.dto.revenue.RevenueMinDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RevenueService {

    RevenueDTO save(RevenueDTO dto);

    Page<RevenueMinDTO> findAll(String name, Pageable pePageable);
    RevenueDTO update(Long id, RevenueDTO dto);
    RevenueDTO findById(Long id);
    void delete(Long id);
}
