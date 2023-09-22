package com.lcdev.restrimais.rest.controller;

import com.lcdev.restrimais.domain.entities.Nutritionist;
import com.lcdev.restrimais.rest.dto.nutritionist.NutritionistAddressDTO;
import com.lcdev.restrimais.rest.dto.nutritionist.NutritionistDTO;
import com.lcdev.restrimais.service.NutritionistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "nutritionists")
public class NutritionistController {

    private final NutritionistService service;

    @PostMapping
    public ResponseEntity<NutritionistAddressDTO> save(@RequestBody NutritionistAddressDTO dto){
        dto = service.save(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NutritionistDTO> update(@PathVariable Long id, @RequestBody NutritionistDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NutritionistAddressDTO> findById(@PathVariable Long id){
        NutritionistAddressDTO entity = service.findById(id);
        return ResponseEntity.ok(entity);
    }

    @GetMapping
    public List<NutritionistDTO> fidAll(){return service.findAll();}

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
