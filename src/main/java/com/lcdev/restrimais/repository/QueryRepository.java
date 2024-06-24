package com.lcdev.restrimais.repository;

import com.lcdev.restrimais.lib.entities.Query;
import com.lcdev.restrimais.lib.enums.QueryStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface QueryRepository extends JpaRepository<Query, Long> {
    List<Query> findByNutritionistIdAndQueryDateBetween(Long nutritionistId, LocalDateTime startDate, LocalDateTime endDate);

    List<Query> findByNutritionistIdAndQueryDateBetweenAndStatus(Long nutritionistId, LocalDateTime startDateTime, LocalDateTime endDateTime, QueryStatus status);

}
