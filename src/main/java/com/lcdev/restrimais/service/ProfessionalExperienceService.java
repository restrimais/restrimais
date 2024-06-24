package com.lcdev.restrimais.service;

import com.lcdev.restrimais.lib.dto.nutritionist.ProfessionalExperienceDTO;

import java.util.List;

public interface ProfessionalExperienceService {

    ProfessionalExperienceDTO findById(Long id);

    List<ProfessionalExperienceDTO> findAll();

    void delete(Long id);
}
