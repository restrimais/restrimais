package com.lcdev.restrimais.repository;

import com.lcdev.restrimais.domain.entities.AssessmentNutritionist;
import com.lcdev.restrimais.domain.entities.AssessmentNutritionistPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentNutritionistRepository extends JpaRepository<AssessmentNutritionist, AssessmentNutritionistPK> {
}
