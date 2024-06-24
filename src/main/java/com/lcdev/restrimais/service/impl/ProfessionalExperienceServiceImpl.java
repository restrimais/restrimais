package com.lcdev.restrimais.service.impl;

import com.lcdev.restrimais.lib.entities.ProfessionalExperience;
import com.lcdev.restrimais.repository.ProfessionalExperienceRepository;
import com.lcdev.restrimais.lib.dto.nutritionist.ProfessionalExperienceDTO;
import com.lcdev.restrimais.service.ProfessionalExperienceService;
import com.lcdev.restrimais.service.exceptions.DatabaseException;
import com.lcdev.restrimais.service.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfessionalExperienceServiceImpl implements ProfessionalExperienceService {

    private final ProfessionalExperienceRepository repository;

    @Override
    @Transactional(readOnly = true)
    public ProfessionalExperienceDTO findById(Long id) {
        ProfessionalExperience entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado."));

        return new ProfessionalExperienceDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProfessionalExperienceDTO> findAll() {
        List<ProfessionalExperience> result = repository.findAll();
        return result.stream().map(ProfessionalExperienceDTO::new).collect(Collectors.toList());
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado!");
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial!");
        }
    }
}
