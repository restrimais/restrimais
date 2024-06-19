package com.lcdev.restrimais.service.impl;

import com.lcdev.restrimais.domain.entities.BlockedSlot;
import com.lcdev.restrimais.domain.entities.Nutritionist;
import com.lcdev.restrimais.repository.BlockedSlotRepository;
import com.lcdev.restrimais.repository.NutritionistRepository;
import com.lcdev.restrimais.rest.dto.consultation.BlockedSlotDTO;
import com.lcdev.restrimais.service.BlockedSlotService;
import com.lcdev.restrimais.service.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BlockedSlotServiceImpl implements BlockedSlotService {

    private final BlockedSlotRepository repository;
    private final NutritionistRepository nutritionistRepository;

    @Override
    public BlockedSlotDTO save(BlockedSlotDTO dto) {

        Nutritionist nutritionist = nutritionistRepository.findById(dto.getNutritionistId())
                .orElseThrow(() -> new ResourceNotFoundException("Nutricionista não encontrado! Id: " + dto.getNutritionistId()));

        BlockedSlot entity = new BlockedSlot();

        entity.setNutritionist(nutritionist);
        entity.setBlockedStart(dto.getBlockedStart());
        entity.setBlockedEnd(dto.getBlockedEnd());

        entity = repository.save(entity);

        return new BlockedSlotDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BlockedSlotDTO> findBlockedSlots(Long nutritionistId) {
        List<BlockedSlot> blockedSlots = repository.findByNutritionistId(nutritionistId);

        return blockedSlots.stream()
                .map(BlockedSlotDTO::new)
                .collect(Collectors.toList());

    }

}
