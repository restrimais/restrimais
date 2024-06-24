package com.lcdev.restrimais.lib.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentRevenuePK implements Serializable {

    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "revenue_id")
    private Long revenueId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssessmentRevenuePK that = (AssessmentRevenuePK) o;
        return Objects.equals(patientId, that.patientId) && Objects.equals(revenueId, that.revenueId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId, revenueId);
    }
}
