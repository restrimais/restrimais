package com.lcdev.restrimais.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_revenue")
public class Revenue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String img;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "revenue")
    private List<Assessment> assessments = new ArrayList<>();

    @OneToOne
    @MapsId
    private Preparation preparation;

    @OneToMany(mappedBy = "revenue")
    private Set<Ingredients> ingredients = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Revenue revenue = (Revenue) o;
        return Objects.equals(id, revenue.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
