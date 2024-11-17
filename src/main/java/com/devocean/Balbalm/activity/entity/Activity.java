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
	private String userId;
	private LocalDate date;
	private int hours;
	private int minutes;
	private int seconds;
	private double distance;
	private int kcal;
}
