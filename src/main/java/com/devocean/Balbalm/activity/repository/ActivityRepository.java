package com.devocean.Balbalm.activity.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.devocean.Balbalm.activity.entity.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
	List<Activity> findByDateAndUserId(LocalDate date, String userId);

	@Query("SELECT a FROM Activity a WHERE YEAR(a.date) = :year AND MONTH(a.date) = :month AND a.userId = :id ORDER BY a.date")
	List<Activity> findByYearAndMonth(@Param("year") int year, @Param("month") int month, @Param("id") String userId);
}
