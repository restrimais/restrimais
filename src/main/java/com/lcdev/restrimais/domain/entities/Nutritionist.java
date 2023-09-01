package com.lcdev.restrimais.domain.entities;

import jakarta.persistence.Column;
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
@Table(name = "tb_nutritionist")
public class Nutritionist extends User{

    private String crn;
    private String specialization;
    private String academicDegree;

    @Column(columnDefinition = "TEXT")
    private String biography;

    @OneToMany(mappedBy = "nutritionist")
    private Set<Address> addresses = new HashSet<>();

    @OneToMany(mappedBy = "nutritionist")
    private List<ProfessionalExperience> experiences = new ArrayList<>();

    @OneToMany(mappedBy = "nutritionist")
    private List<Assessment> assessments = new ArrayList<>();

    @OneToMany(mappedBy = "nutritionist")
    private Set<Query> queries = new HashSet<>();
}
