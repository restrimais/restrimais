package com.lcdev.restrimais.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_preparation")
public class Preparation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String step;
    private String time;
    private String temperature;

    @Column(columnDefinition = "TEXT")
    private String observation;

    @OneToOne(mappedBy = "preparation", cascade = CascadeType.ALL)
    private Revenue revenue;
}
