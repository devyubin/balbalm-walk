package com.devocean.Balbalm.walk.repository;

import com.devocean.Balbalm.walk.entity.Walk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface WalkRepository extends JpaRepository<Walk, Long> {
    List<Walk> findByCreatedTimeBetween(LocalDate startDate, LocalDate endDate);
    List<Walk> findByCreatedTimeAndUserId(LocalDate createdDate, String userId);
}
