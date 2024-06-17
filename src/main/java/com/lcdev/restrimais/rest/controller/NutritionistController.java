package com.lcdev.restrimais.rest.controller;

import com.lcdev.restrimais.rest.dto.nutritionist.NutritionistAddressDTO;
import com.lcdev.restrimais.rest.dto.nutritionist.NutritionistAssessmentDTO;
import com.lcdev.restrimais.rest.dto.nutritionist.NutritionistDTO;
import com.lcdev.restrimais.rest.dto.nutritionist.NutritionistMinDTO;
import com.lcdev.restrimais.rest.dto.revenue.RevenueMinDTO;
import com.lcdev.restrimais.service.NutritionistService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "nutritionists")
public class NutritionistController {

    private final NutritionistService service;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    @PostMapping
    public ResponseEntity<NutritionistAddressDTO> save(@RequestBody NutritionistAddressDTO dto){
        dto = service.save(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    @PutMapping("/{id}")
    public ResponseEntity<NutritionistDTO> update(@PathVariable Long id, @RequestBody NutritionistDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    @GetMapping("/{id}")
    public ResponseEntity<NutritionistAssessmentDTO> findById(@PathVariable Long id){
        NutritionistAssessmentDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<Page<NutritionistMinDTO>> fidAll(
            @RequestParam(name = "name", defaultValue = "") String name, Pageable pageable
    ){
        Page<NutritionistMinDTO> dto = service.findAll(name, pageable);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
