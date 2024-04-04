package com.lcdev.restrimais.rest.controller;

import com.lcdev.restrimais.rest.dto.revenue.RevenueDTO;
import com.lcdev.restrimais.rest.dto.revenue.RevenueMinDTO;
import com.lcdev.restrimais.service.RevenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/revenues")
public class RevenueController {

    private final RevenueService service;

    @GetMapping
    public ResponseEntity<Page<RevenueMinDTO>> findAll(
            @RequestParam(name = "title", defaultValue = "") String title,
            Pageable pageable){
        Page<RevenueMinDTO> dto = service.findAll(title, pageable);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RevenueDTO> findById(@PathVariable Long id){
        RevenueDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

}
