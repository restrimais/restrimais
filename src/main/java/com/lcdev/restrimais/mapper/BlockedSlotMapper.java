package com.lcdev.restrimais.mapper;

import com.lcdev.restrimais.domain.entities.BlockedSlot;
import com.lcdev.restrimais.domain.entities.Nutritionist;
import com.lcdev.restrimais.rest.dto.consultation.BlockedSlotDTO;

public interface BlockedSlotMapper {

    BlockedSlot mapBlockedSlot(BlockedSlotDTO dto, Nutritionist nutritionist);
}
