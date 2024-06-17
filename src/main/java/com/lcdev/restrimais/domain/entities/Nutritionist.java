package com.lcdev.restrimais.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_nutritionist")
public class Nutritionist extends User{

    private String crn;
    private String specialization;
    private String academicDegree;
    private Double score;
    private Integer count;

    @Column(columnDefinition = "TEXT")
    private String biography;

    @OneToMany(mappedBy = "nutritionist", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "nutritionist")
    private List<ProfessionalExperience> experiences = new ArrayList<>();

    @OneToMany(mappedBy = "nutritionist")
    private Set<AssessmentNutritionist> assessments = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "tb_nutritionist_role",
            joinColumns = @JoinColumn(name = "nutritionist_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public void addRole(Role role) {
        roles.add(role);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getAuthority())).collect(Collectors.toSet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Nutritionist that = (Nutritionist) o;
        return Objects.equals(crn, that.crn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), crn);
    }
}
