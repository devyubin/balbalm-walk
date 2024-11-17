package com.devocean.Balbalm.walk.repository;

import com.devocean.Balbalm.walk.entity.Walk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface WalkRepository extends JpaRepository<Walk, Long> {
    List<Walk> findByCreatedTimeBetween(LocalDate startDate, LocalDate endDate);
    List<Walk> findByCreatedTimeAndUserId(LocalDate createdDate, String userId);
    @Query("SELECT w FROM Walk w WHERE YEAR(w.createdTime) = :year AND MONTH(w.createdTime) = :month AND w.userId = :id ORDER BY w.createdTime")
    List<Walk> findByYearAndMonth(@Param("year") int year, @Param("month") int month, @Param("id") String userId);
}
