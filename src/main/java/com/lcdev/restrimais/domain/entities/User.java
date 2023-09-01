package com.lcdev.restrimais.domain.entities;

import com.lcdev.restrimais.domain.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@MappedSuperclass
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private LocalDate birthDate;
    private String password;
    private String cpf;

//    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String profileImg;
    private String phone;
}
