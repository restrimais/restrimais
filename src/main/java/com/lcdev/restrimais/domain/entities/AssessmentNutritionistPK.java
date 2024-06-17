package com.lcdev.restrimais.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentNutritionistPK implements Serializable {

    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "nutritionist_id")
    private Long nutritionistId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssessmentNutritionistPK that = (AssessmentNutritionistPK) o;
        return Objects.equals(patientId, that.patientId) && Objects.equals(nutritionistId, that.nutritionistId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId, nutritionistId);
    }
}
