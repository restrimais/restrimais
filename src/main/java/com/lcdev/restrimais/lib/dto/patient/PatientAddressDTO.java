package com.lcdev.restrimais.lib.dto.patient;

import com.lcdev.restrimais.lib.dto.restriction.RestrictionMinDTO;
import com.lcdev.restrimais.lib.entities.Patient;
import com.lcdev.restrimais.lib.enums.Gender;
import com.lcdev.restrimais.lib.dto.address.AddressDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientAddressDTO {

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
    private List<RestrictionMinDTO> restrictions = new ArrayList<>();

    public PatientAddressDTO(Patient entity){
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
        restrictions = entity.getRestrictions().stream().map(RestrictionMinDTO::new).collect(Collectors.toList());
    }
}
