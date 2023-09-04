package com.lcdev.restrimais.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@Entity
@Table(name = "tb_revenue")
public class Revenue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String img;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "revenue")
    private List<Assessment> assessments = new ArrayList<>();

    @OneToOne
    @MapsId
    private Preparation preparation;

    @OneToMany(mappedBy = "revenue")
    private List<Ingredients> ingredients = new ArrayList<>();
}
