package com.lcdev.restrimais.rest.controller;

import com.lcdev.restrimais.rest.dto.city.CityStateDTO;
import com.lcdev.restrimais.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "cities")
public class CityController {

    @Autowired
    private CityService service;

    @PostMapping
    public ResponseEntity<CityStateDTO> save(@RequestBody CityStateDTO dto){
        dto = service.save(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CityStateDTO> findById(@PathVariable Long id){
        CityStateDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public List<CityStateDTO> findAll(){
        return service.findAll();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CityStateDTO> update(@PathVariable Long id, @RequestBody CityStateDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
