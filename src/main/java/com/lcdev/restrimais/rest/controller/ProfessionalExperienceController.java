package com.lcdev.restrimais.rest.controller;

import com.lcdev.restrimais.rest.dto.nutritionist.ProfessionalExperienceDTO;
import com.lcdev.restrimais.service.ProfessionalExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "experiences")
public class ProfessionalExperienceController {

    private final ProfessionalExperienceService service;

    @GetMapping("/{id}")
    public ResponseEntity<ProfessionalExperienceDTO> update(@PathVariable Long id){
        ProfessionalExperienceDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public List<ProfessionalExperienceDTO> findAll(){
        return service.findAll();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
