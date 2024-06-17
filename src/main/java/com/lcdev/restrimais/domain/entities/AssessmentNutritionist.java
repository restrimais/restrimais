package com.lcdev.restrimais.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_assessment_nutritionist")
public class AssessmentNutritionist {

    @EmbeddedId
    private AssessmentNutritionistPK id;

    @ManyToOne
    @MapsId("patient_id")
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @MapsId("nutritionist_id")
    @JoinColumn(name = "nutritionist_id")
    private Nutritionist nutritionist;

    private Double valor;
    private String comment;


}