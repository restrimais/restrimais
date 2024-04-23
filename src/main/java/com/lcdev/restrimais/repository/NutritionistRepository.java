package com.lcdev.restrimais.repository;

import com.lcdev.restrimais.domain.entities.Nutritionist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutritionistRepository extends JpaRepository<Nutritionist, Long> {

    Nutritionist findByEmail(String email);
}
