package com.devocean.Balbalm.activity.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.devocean.Balbalm.activity.entity.dto.ActivityDto;
import com.devocean.Balbalm.activity.repository.ActivityRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActivityService {
	private final ActivityRepository activityRepository;

	public List<ActivityDto> getActivities(LocalDate date) {
		return activityRepository.findByDate(date).stream()
			.map(activity -> ActivityDto.of(activity))
			.collect(Collectors.toList());
	}
}
