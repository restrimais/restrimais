package com.lcdev.restrimais.rest.controller;

import com.lcdev.restrimais.rest.dto.patient.PatientAddressDTO;
import com.lcdev.restrimais.rest.dto.patient.PatientDTO;
import com.lcdev.restrimais.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "patients")
public class PatientController {

    private final PatientService service;

    @PostMapping
    public ResponseEntity<PatientAddressDTO> save(@RequestBody PatientAddressDTO dto){
        dto = service.save(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> update(@PathVariable Long id, @RequestBody PatientDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientAddressDTO> findById(@PathVariable Long id){
        PatientAddressDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public List<PatientDTO> findAll(){
        return service.findAll();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
