package com.lcdev.restrimais.rest.dto.nutritionist;

import com.lcdev.restrimais.domain.entities.Nutritionist;
import com.lcdev.restrimais.domain.enums.Gender;
import com.lcdev.restrimais.rest.dto.address.AddressDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NutritionistDTO {

    private Long id;
    private String name;
    private String email;
    private LocalDate birthDate;
    private String password;
    private String cpf;
    private Gender gender;
    private String profileImg;
    private String phone;
    private String crn;
    private String specialization;
    private String academicDegree;
    private String biography;

    private List<AddressDTO> address = new ArrayList<>();

    public NutritionistDTO(Nutritionist entity){
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
        birthDate = entity.getBirthDate();
        password = entity.getPassword();
        cpf = entity.getCpf();
        gender = entity.getGender();
        profileImg = entity.getProfileImg();
        phone = entity.getPhone();
        crn = entity.getCrn();
        specialization = entity.getSpecialization();
        academicDegree = entity.getAcademicDegree();
        biography = entity.getBiography();
        address = entity.getAddresses().stream().map(AddressDTO::new).collect(Collectors.toList());
    }
}
