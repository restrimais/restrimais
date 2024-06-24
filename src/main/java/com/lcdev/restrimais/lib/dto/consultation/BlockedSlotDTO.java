package com.lcdev.restrimais.lib.dto.consultation;

import com.lcdev.restrimais.lib.entities.BlockedSlot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlockedSlotDTO {

    private Long id;
    private Long nutritionistId;
    private LocalDateTime blockedStart;
    private LocalDateTime blockedEnd;

    public BlockedSlotDTO(BlockedSlot entity){
        id = entity.getId();
        nutritionistId = entity.getNutritionist().getId();
        blockedStart = entity.getBlockedStart();
        blockedEnd = entity.getBlockedEnd();
    }
}
