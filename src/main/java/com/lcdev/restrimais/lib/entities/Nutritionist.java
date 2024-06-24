package com.lcdev.restrimais.lib.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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

    @OneToMany(mappedBy = "nutritionist")
    private List<WorkSchedule> availableHours = new ArrayList<>();

    @OneToMany(mappedBy = "nutritionist")
    private List<Query> queries = new ArrayList<>();

    @OneToMany(mappedBy = "nutritionist")
    private List<BlockedSlot> blockedSlots = new ArrayList<>();

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
