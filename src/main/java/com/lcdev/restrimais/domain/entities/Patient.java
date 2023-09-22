package com.lcdev.restrimais.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Entity
@Table(name = "tb_patient")
public class Patient extends User{

    private Double height;
    private Double weight;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "patient")
    private Set<Restriction> restrictions = new HashSet<>();

    @OneToMany(mappedBy = "patient")
    private List<Assessment> assessments = new ArrayList<>();

    @OneToMany(mappedBy = "patient")
    private Set<Query> queries = new HashSet<>();

}
