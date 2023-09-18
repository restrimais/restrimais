package com.lcdev.restrimais.service.impl;

import com.lcdev.restrimais.domain.entities.Address;
import com.lcdev.restrimais.domain.entities.Nutritionist;
import com.lcdev.restrimais.repository.NutritionistRepository;
import com.lcdev.restrimais.rest.dto.address.AddressDTO;
import com.lcdev.restrimais.rest.dto.nutritionist.NutritionistDTO;
import com.lcdev.restrimais.service.AddressService;
import com.lcdev.restrimais.service.NutritionistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class NutritionistServiceImpl implements NutritionistService {

    private final NutritionistRepository repository;

    private final AddressService addressService;

    @Transactional
    public NutritionistDTO save(NutritionistDTO dto){
        Nutritionist entity = new Nutritionist();
        copyDtoToEntity(dto, entity);

        entity = repository.save(entity);
        return new NutritionistDTO(entity);
    }

    public void copyDtoToEntity(NutritionistDTO dto, Nutritionist entity){
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

        for (AddressDTO addressDTO : dto.getAddress()) {
            Address address = new Address();
            addressService.copyDtoToEntity(addressDTO, address);

            entity.getAddresses().add(address);
        }
    }
}
