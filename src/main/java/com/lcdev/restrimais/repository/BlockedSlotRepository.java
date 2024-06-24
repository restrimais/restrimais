package com.lcdev.restrimais.repository;

import com.lcdev.restrimais.lib.entities.BlockedSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlockedSlotRepository extends JpaRepository<BlockedSlot, Long> {
    List<BlockedSlot> findByNutritionistId(Long nutritionistId);

}
