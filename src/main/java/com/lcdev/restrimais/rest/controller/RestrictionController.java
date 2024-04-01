package com.lcdev.restrimais.rest.controller;

import com.lcdev.restrimais.rest.dto.restriction.RestrictionMinDTO;
import com.lcdev.restrimais.service.RestrictionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/restrictions")
public class RestrictionController {

    private final RestrictionService service;
    @GetMapping
    public ResponseEntity<List<RestrictionMinDTO>> findAll(){
        List<RestrictionMinDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RestrictionMinDTO> findById(@PathVariable Long id){
        RestrictionMinDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<RestrictionMinDTO> save(@RequestBody RestrictionMinDTO dto){
        dto = service.save(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

}
