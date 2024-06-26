package com.lcdev.restrimais.service.impl;

import com.lcdev.restrimais.lib.entities.Revenue;
import com.lcdev.restrimais.mapper.RevenueMapper;
import com.lcdev.restrimais.repository.RevenueRepository;
import com.lcdev.restrimais.lib.dto.revenue.RevenueDTO;
import com.lcdev.restrimais.lib.dto.revenue.RevenueMinDTO;
import com.lcdev.restrimais.service.RevenueService;
import com.lcdev.restrimais.service.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RevenueServiceImpl implements RevenueService {

    private final RevenueRepository repository;

    private final RevenueMapper revenueMapper;

    @Override
    @Transactional()
    public RevenueDTO save(RevenueDTO dto) {
        Revenue entity = revenueMapper.mapRevenue(dto);

        entity = repository.save(entity);
        return new RevenueDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<RevenueMinDTO> findAll(String title, Pageable pePageable) {
        Page<Revenue> result = repository.searchByName(title, pePageable);
        return result.map(RevenueMinDTO::new);
    }

    @Override
    public RevenueDTO update(Long id, RevenueDTO dto) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public RevenueDTO findById(Long id) {
        Revenue entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado!"));
        return new RevenueDTO(entity);
    }

    @Override
    public void delete(Long id) {

    }
}
