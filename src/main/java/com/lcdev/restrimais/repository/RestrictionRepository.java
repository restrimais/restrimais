package com.lcdev.restrimais.repository;

import com.lcdev.restrimais.domain.entities.Restriction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestrictionRepository extends JpaRepository<Restriction, Long> {

}
