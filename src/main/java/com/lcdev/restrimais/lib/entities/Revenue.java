package com.lcdev.restrimais.lib.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Double score;
    private Integer count;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "revenue")
    private Set<AssessmentRevenue> assessments = new HashSet<>();

    @OneToOne
    @MapsId
    private Preparation preparation;

    @OneToMany(mappedBy = "revenue",  fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ingredient> ingredients = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "tb_revenue_category",
            joinColumns = @JoinColumn(name = "revenue_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

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
