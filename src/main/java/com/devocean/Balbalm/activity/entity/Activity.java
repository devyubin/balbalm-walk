package com.devocean.Balbalm.activity.entity;

import java.time.Duration;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Activity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long user_id;
	private LocalDate date;
	private Long hours;
	private Long minutes;
	private Long seconds;
	private double distance;
	private int kcal;
}
