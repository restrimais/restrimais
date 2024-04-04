package com.lcdev.restrimais.rest.controller;

import com.lcdev.restrimais.rest.dto.revenue.RevenueMinDTO;
import com.lcdev.restrimais.service.RevenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
