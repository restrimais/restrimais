package com.lcdev.restrimais.repository;

import com.lcdev.restrimais.domain.entities.AssessmentRevenue;
import com.lcdev.restrimais.domain.entities.AssessmentRevenuePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentRevenueRepository extends JpaRepository<AssessmentRevenue, AssessmentRevenuePK> {
}
