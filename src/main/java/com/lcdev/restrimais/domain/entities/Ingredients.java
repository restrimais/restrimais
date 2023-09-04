package com.lcdev.restrimais.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "tb_ingredients")
public class Ingredients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String igredient;

    @ManyToOne
    @JoinColumn(name = "revenue_id")
    private Revenue revenue;
}
