package com.lcdev.restrimais.rest.controller;

import com.lcdev.restrimais.rest.dto.state.StateCityDTO;
import com.lcdev.restrimais.rest.dto.state.StateDTO;
import com.lcdev.restrimais.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "states")
public class StateController {

    @Autowired
    private StateService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<StateDTO> findById(@PathVariable Long id){
        StateDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public List<StateCityDTO> findAll(){
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<StateDTO> save(@RequestBody StateDTO dto){
        dto = service.save(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<StateDTO> update(@PathVariable Long id, @RequestBody StateDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
