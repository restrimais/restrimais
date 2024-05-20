package com.lcdev.restrimais.repository;

import com.lcdev.restrimais.domain.entities.Nutritionist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NutritionistRepository extends JpaRepository<Nutritionist, Long> {
    Optional<Nutritionist> findByEmail(String email);
}
