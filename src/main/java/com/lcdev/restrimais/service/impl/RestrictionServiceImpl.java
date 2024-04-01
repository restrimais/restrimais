package com.lcdev.restrimais.service.impl;

import com.lcdev.restrimais.domain.entities.Patient;
import com.lcdev.restrimais.domain.entities.Restriction;
import com.lcdev.restrimais.mapper.RestrictionMapper;
import com.lcdev.restrimais.repository.RestrictionRepository;
import com.lcdev.restrimais.rest.dto.restriction.RestrictionMinDTO;
import com.lcdev.restrimais.service.RestrictionService;
import com.lcdev.restrimais.service.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestrictionServiceImpl implements RestrictionService {

    private final RestrictionRepository repository;

    private final RestrictionMapper restrictionMapper;

    @Override
    @Transactional(readOnly = true)
    public List<RestrictionMinDTO> findAll() {
        List<Restriction> result = repository.findAll();
        return result.stream().map(RestrictionMinDTO::new).toList();
    }

    @Override
    @Transactional()
    public RestrictionMinDTO save(RestrictionMinDTO dto) {
        Restriction entity = repository.save(restrictionMapper.mapRestriction(dto));
        return new RestrictionMinDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public RestrictionMinDTO findById(Long id){
        Restriction restriction = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado!"));
        return new RestrictionMinDTO(restriction);
    }

    @Override
    @Transactional()
    public Restriction persistRestriction(RestrictionMinDTO dto, Patient patient) {
        Restriction restriction = repository.save(restrictionMapper.mapRestriction(dto));
        restriction.setPatient(patient);
        return restriction;
    }
}
