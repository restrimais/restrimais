package com.lcdev.restrimais.repository;

import com.lcdev.restrimais.lib.entities.ProfessionalExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalExperienceRepository extends JpaRepository<ProfessionalExperience, Long> {
}
