package com.lcdev.restrimais.service.impl;

import com.lcdev.restrimais.lib.entities.Nutritionist;
import com.lcdev.restrimais.mapper.NutritionistMapper;
import com.lcdev.restrimais.repository.NutritionistRepository;
import com.lcdev.restrimais.lib.dto.address.AddressDTO;
import com.lcdev.restrimais.lib.dto.nutritionist.NutritionistAddressDTO;
import com.lcdev.restrimais.lib.dto.nutritionist.NutritionistAssessmentDTO;
import com.lcdev.restrimais.lib.dto.nutritionist.NutritionistDTO;
import com.lcdev.restrimais.lib.dto.nutritionist.NutritionistMinDTO;
import com.lcdev.restrimais.service.AddressService;
import com.lcdev.restrimais.service.NutritionistService;
import com.lcdev.restrimais.service.exceptions.DatabaseException;
import com.lcdev.restrimais.service.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class NutritionistServiceImpl implements NutritionistService {

    private final NutritionistRepository repository;

    private final NutritionistMapper nutritionistMapper;

    private final AddressService addressService;

    @Transactional
    public NutritionistAddressDTO save(NutritionistAddressDTO dto){
       try {
           Nutritionist entity = nutritionistMapper.mapNutritionistAdress(dto);

           for (AddressDTO addressDTO : dto.getAddress()) {
               entity.getAddresses().add(addressService.persistAddress(addressDTO, null, entity));
           }

           entity = repository.save(entity);
           return new NutritionistAddressDTO(entity);
       } catch (DataIntegrityViolationException e){
            throw new DatabaseException("Email já cadastrado: " + dto.getEmail());
       }
    }

    @Transactional
    public NutritionistDTO update(Long id, NutritionistDTO dto){
        Nutritionist entity = repository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado."));
        nutritionistMapper.mapNutritionist(dto, entity);
        entity = repository.save(entity);
        return new NutritionistDTO(entity);
    }


    @Override
    @Transactional(readOnly = true)
    public NutritionistAssessmentDTO findById(Long id){
        Nutritionist entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado."));
        return new NutritionistAssessmentDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<NutritionistMinDTO> findAll(String name, Pageable pageable) {
        Page<Nutritionist> result = repository.searchByName(name, pageable);
        return result.map(NutritionistMinDTO::new);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado!");
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial!");
        }
    }

}
