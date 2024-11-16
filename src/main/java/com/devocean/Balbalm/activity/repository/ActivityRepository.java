package com.devocean.Balbalm.activity.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devocean.Balbalm.activity.entity.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
	List<Activity> findByDate(LocalDate date);

	@Query("SELECT a FROM Activity a WHERE YEAR(a.date) = :year AND MONTH(a.date) = :month ORDER BY a.date")
	List<Activity> findByYearAndMonth(@Param("year") int year, @Param("month") int month);
}
