package com.lcdev.restrimais.service;

import com.lcdev.restrimais.lib.dto.consultation.BlockedSlotDTO;

import java.util.List;

public interface BlockedSlotService {

    BlockedSlotDTO save(BlockedSlotDTO dto);
    List<BlockedSlotDTO> findBlockedSlots(Long nutritionistId);

}
