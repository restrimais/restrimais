package com.lcdev.restrimais.repository;

import com.lcdev.restrimais.lib.entities.WorkSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface WorkScheduleRepository extends JpaRepository<WorkSchedule, Long> {
    List<WorkSchedule> findByNutritionistId(Long nutritionistId);

    @Query("SELECT w FROM WorkSchedule w WHERE w.nutritionist.id = :nutritionistId AND w.dayOfWeek = :dayOfWeek")
    List<WorkSchedule> findByNutritionistIdAndDayOfWeek(Long nutritionistId, DayOfWeek dayOfWeek);

    @Query("SELECT COUNT(ws) > 0 FROM WorkSchedule ws " +
            "WHERE ws.nutritionist.id = :nutritionistId " +
            "AND ws.dayOfWeek = :dayOfWeek " +
            "AND ws.startTime = :startTime " +
            "AND ws.endTime = :endTime")
    boolean existsByNutritionistIdAndDayOfWeekAndStartTimeAndEndTime(Long nutritionistId, DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime);
}
