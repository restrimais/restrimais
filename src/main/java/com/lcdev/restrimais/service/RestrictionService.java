package com.lcdev.restrimais.service;

import com.lcdev.restrimais.lib.entities.Patient;
import com.lcdev.restrimais.lib.entities.Restriction;
import com.lcdev.restrimais.lib.dto.restriction.RestrictionMinDTO;

import java.util.List;

public interface RestrictionService {
    List<RestrictionMinDTO> findAll();
    RestrictionMinDTO save(RestrictionMinDTO dto);
    RestrictionMinDTO findById(Long id);
    Restriction persistRestriction(RestrictionMinDTO dto, Patient patient);

}
