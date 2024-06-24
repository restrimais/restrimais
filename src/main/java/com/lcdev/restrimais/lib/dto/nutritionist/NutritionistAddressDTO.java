package com.lcdev.restrimais.lib.dto.nutritionist;

import com.lcdev.restrimais.lib.entities.Nutritionist;
import com.lcdev.restrimais.lib.enums.Gender;
import com.lcdev.restrimais.lib.dto.address.AddressDTO;
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
public class NutritionistAddressDTO {

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

    public NutritionistAddressDTO(Nutritionist entity){
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
