package com.lcdev.restrimais.repository;

import com.lcdev.restrimais.domain.entities.Assessment;
import com.lcdev.restrimais.domain.entities.AssessmentRevenuePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, AssessmentRevenuePK> {
}
