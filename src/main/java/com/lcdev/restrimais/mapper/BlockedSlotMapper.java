package com.lcdev.restrimais.mapper;

import com.lcdev.restrimais.lib.entities.BlockedSlot;
import com.lcdev.restrimais.lib.entities.Nutritionist;
import com.lcdev.restrimais.lib.dto.consultation.BlockedSlotDTO;

public interface BlockedSlotMapper {

    BlockedSlot mapBlockedSlot(BlockedSlotDTO dto, Nutritionist nutritionist);
}
