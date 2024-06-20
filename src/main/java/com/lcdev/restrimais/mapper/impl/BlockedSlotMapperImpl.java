package com.lcdev.restrimais.mapper.impl;

import com.lcdev.restrimais.domain.entities.BlockedSlot;
import com.lcdev.restrimais.domain.entities.Nutritionist;
import com.lcdev.restrimais.mapper.BlockedSlotMapper;
import com.lcdev.restrimais.rest.dto.consultation.BlockedSlotDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BlockedSlotMapperImpl implements BlockedSlotMapper {
    @Override
    public BlockedSlot mapBlockedSlot(BlockedSlotDTO dto, Nutritionist nutritionist) {

        BlockedSlot entity = new BlockedSlot();

        entity.setNutritionist(nutritionist);
        entity.setBlockedStart(dto.getBlockedStart());
        entity.setBlockedEnd(dto.getBlockedEnd());

        return entity;
    }
}
