package com.lcdev.restrimais.service.impl;

import com.lcdev.restrimais.domain.entities.Restriction;
import com.lcdev.restrimais.mapper.RestrictionMapper;
import com.lcdev.restrimais.repository.RestrictionRepository;
import com.lcdev.restrimais.rest.dto.restriction.RestrictionDTO;
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
    public List<RestrictionDTO> findAll() {
        List<Restriction> result = repository.findAll();
        return result.stream().map(RestrictionDTO::new).toList();
    }

    @Override
    @Transactional()
    public RestrictionDTO save(RestrictionDTO dto) {
        Restriction entity = repository.save(restrictionMapper.mapRestriction(dto));
        return new RestrictionDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public RestrictionDTO findById(Long id){
        Restriction restriction = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado!"));
        return new RestrictionDTO(restriction);
    }

}
