package com.devocean.Balbalm.activity.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.devocean.Balbalm.activity.entity.Activity;
import com.devocean.Balbalm.activity.entity.dto.ActivityDto;
import com.devocean.Balbalm.activity.repository.ActivityRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ActivityService {
	private final ActivityRepository activityRepository;

	public List<ActivityDto> getActivities(String user_id, LocalDate date) {
		return activityRepository.findByDateAndUserId(date, user_id).stream()
			.map(activity -> ActivityDto.of(activity))
			.collect(Collectors.toList());
	}

	public List<Integer> getActivitiesInMonth(String user_id, int year, int month) {
		return activityRepository.findByYearAndMonth(year, month, user_id)
			.stream().map(activity -> activity.getDate().getDayOfMonth()).collect(Collectors.toList());
	}
}
