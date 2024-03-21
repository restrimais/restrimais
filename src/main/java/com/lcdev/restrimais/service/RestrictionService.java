package com.lcdev.restrimais.service;

import com.lcdev.restrimais.rest.dto.restriction.RestrictionDTO;

import java.util.List;

public interface RestrictionService {
    List<RestrictionDTO> findAll();
    RestrictionDTO save(RestrictionDTO dto);

    RestrictionDTO findById(Long id);

}
