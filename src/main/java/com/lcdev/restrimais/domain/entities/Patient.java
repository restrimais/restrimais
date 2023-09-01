package com.lcdev.restrimais.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ToString
@Entity
@Table(name = "tb_patient")
public class Patient extends User{

    private String cpf;
    private Double height;
    private Double weight;

    @OneToMany(mappedBy = "patient")
    private Set<Address> addresses = new HashSet<>();

    @OneToMany(mappedBy = "patient")
    private Set<Restriction> restrictions = new HashSet<>();

    @OneToMany(mappedBy = "patient")
    private List<Assessment> assessments = new ArrayList<>();
}
