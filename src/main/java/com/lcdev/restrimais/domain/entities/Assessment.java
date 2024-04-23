package com.lcdev.restrimais.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_assessment")
public class Assessment {

    @EmbeddedId
    private AssessmentRevenuePK id;

    @ManyToOne
    @MapsId("patient_id")
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @MapsId("revenue_id")
    @JoinColumn(name = "revenue_id")
    private Revenue revenue;

    private Double valor;
    private String comment;


}