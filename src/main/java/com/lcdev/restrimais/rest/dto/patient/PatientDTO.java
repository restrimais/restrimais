package com.lcdev.restrimais.rest.dto.patient;

import com.lcdev.restrimais.domain.entities.Patient;
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
public class PatientDTO {

    private Long id;
    private String name;
    private String email;
    private LocalDate birthDate;
    private String password;
    private String cpf;
    private Gender gender;
    private String profileImg;
    private String phone;
    private Double height;
    private Double weight;
    private List<AddressDTO> address = new ArrayList<>();

    public PatientDTO(Patient entity){
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
        birthDate = entity.getBirthDate();
        password = entity.getPassword();
        cpf = entity.getCpf();
        gender = entity.getGender();
        profileImg = entity.getProfileImg();
        phone = entity.getPhone();
        height = entity.getHeight();
        weight = entity.getWeight();
        address = entity.getAddresses().stream().map(AddressDTO::new).collect(Collectors.toList());
    }
}
