package com.lcdev.restrimais.mapper.impl;

import com.lcdev.restrimais.lib.entities.Nutritionist;
import com.lcdev.restrimais.mapper.AddressMapper;
import com.lcdev.restrimais.mapper.NutritionistMapper;
import com.lcdev.restrimais.lib.dto.nutritionist.NutritionistAddressDTO;
import com.lcdev.restrimais.lib.dto.nutritionist.NutritionistDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NutritionistMapperImpl implements NutritionistMapper {

    private final AddressMapper addressMapper;

    @Override
    public Nutritionist mapNutritionistAdress(NutritionistAddressDTO dto) {

        Nutritionist entity = new Nutritionist();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setBirthDate(dto.getBirthDate());
        entity.setPassword(dto.getPassword());
        entity.setCpf(dto.getCpf());
        entity.setGender(dto.getGender());
        entity.setProfileImg(dto.getProfileImg());
        entity.setPhone(dto.getPhone());
        entity.setCrn(dto.getCrn());
        entity.setSpecialization(dto.getSpecialization());
        entity.setAcademicDegree(dto.getAcademicDegree());
        entity.setBiography(dto.getBiography());

        return entity;
    }

    @Override
    public Nutritionist mapNutritionist(NutritionistDTO dto, Nutritionist entity) {

        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setBirthDate(dto.getBirthDate());
        entity.setPassword(dto.getPassword());
        entity.setCpf(dto.getCpf());
        entity.setGender(dto.getGender());
        entity.setProfileImg(dto.getProfileImg());
        entity.setPhone(dto.getPhone());
        entity.setCrn(dto.getCrn());
        entity.setSpecialization(dto.getSpecialization());
        entity.setAcademicDegree(dto.getAcademicDegree());
        entity.setBiography(dto.getBiography());

        return entity;
    }
}
