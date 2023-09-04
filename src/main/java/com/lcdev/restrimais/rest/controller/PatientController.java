package com.lcdev.restrimais.rest.controller;

import com.lcdev.restrimais.rest.dto.patient.PatientDTO;
import com.lcdev.restrimais.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "patients")
public class PatientController {

    @Autowired
    private PatientService service;

    @PostMapping
    public ResponseEntity<PatientDTO> save(@RequestBody PatientDTO dto){
        dto = service.save(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}