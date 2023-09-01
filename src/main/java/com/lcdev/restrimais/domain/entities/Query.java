package com.lcdev.restrimais.domain.entities;

import com.lcdev.restrimais.domain.enums.QueryStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_query")
public class Query {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime queryDate;
    private QueryStatus status;
    private String observation;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "nutritionist_id")
    private Nutritionist nutritionist;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}
