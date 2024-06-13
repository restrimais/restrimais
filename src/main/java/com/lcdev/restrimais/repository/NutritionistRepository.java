package com.lcdev.restrimais.repository;

import com.lcdev.restrimais.domain.entities.Nutritionist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NutritionistRepository extends JpaRepository<Nutritionist, Long> {
    Optional<Nutritionist> findByEmail(String email);

    @Query("SELECT obj FROM Nutritionist obj " +
            "WHERE UPPER(obj.name) LIKE UPPER(CONCAT('%', :name, '%'))")
    Page<Nutritionist> searchByName(String name, Pageable pageable);

}
