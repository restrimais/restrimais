package com.lcdev.restrimais.rest.controller;

import com.lcdev.restrimais.rest.dto.consultation.BlockedSlotDTO;
import com.lcdev.restrimais.rest.dto.consultation.WorkScheduleDTO;
import com.lcdev.restrimais.service.BlockedSlotService;
import com.lcdev.restrimais.service.WorkScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/blocked-slots")
public class BlockedSlotController {

    private final BlockedSlotService service;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    @PostMapping
    public ResponseEntity<BlockedSlotDTO> save(@RequestBody BlockedSlotDTO dto){
        dto = service.save(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping("/{nutritionistId}")
    public ResponseEntity<List<BlockedSlotDTO>> findBlockedSlots(@PathVariable Long nutritionistId) {
        List<BlockedSlotDTO> blockedSlots = service.findBlockedSlots(nutritionistId);
        return ResponseEntity.ok(blockedSlots);
    }


}
