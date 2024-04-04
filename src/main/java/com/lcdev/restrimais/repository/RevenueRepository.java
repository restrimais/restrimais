package com.lcdev.restrimais.repository;

import com.lcdev.restrimais.domain.entities.Revenue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RevenueRepository extends JpaRepository<Revenue, Long> {

    @Query("SELECT obj FROM Revenue obj " +
            "WHERE UPPER(obj.title) LIKE UPPER(CONCAT('%', :title, '%'))")
    Page<Revenue> searchByName(String title, Pageable pageable);
}
