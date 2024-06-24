package com.lcdev.restrimais.lib.dto.nutritionist;

import com.lcdev.restrimais.lib.entities.Nutritionist;
import com.lcdev.restrimais.lib.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
    }

}
