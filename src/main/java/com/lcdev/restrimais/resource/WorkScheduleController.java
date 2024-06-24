package com.lcdev.restrimais.resource;

import com.lcdev.restrimais.lib.dto.consultation.WorkScheduleDTO;
import com.lcdev.restrimais.service.WorkScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/work-schedules")
public class WorkScheduleController {

    private final WorkScheduleService service;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    @PostMapping
    public ResponseEntity<WorkScheduleDTO> save(@RequestBody WorkScheduleDTO dto){
        dto = service.save(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping("/{nutritionistId}/available-slots")
    public ResponseEntity<List<LocalDateTime>> generateAvailableSlots(@PathVariable Long nutritionistId,
                                                                      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                                      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        List<LocalDateTime> availableSlots = service.generateAvailableSlots(nutritionistId, startDate, endDate);
        return ResponseEntity.ok(availableSlots);
    }


}
