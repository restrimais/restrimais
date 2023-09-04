package com.lcdev.restrimais.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "tb_assessment", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"patient_id", "nutritionist_id"}),
        @UniqueConstraint(columnNames = {"patient_id", "revenue_id"}),
        @UniqueConstraint(columnNames = {"nutritionist_id", "revenue_id"})
})
public class Assessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double score;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "nutritionist_id")
    private Nutritionist nutritionist;

    @ManyToOne
    @JoinColumn(name = "revenue_id")
    private Revenue revenue;

}
