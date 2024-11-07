package com.devocean.Balbalm.activity.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devocean.Balbalm.activity.entity.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
	List<Activity> findByDate(LocalDate date);
}
