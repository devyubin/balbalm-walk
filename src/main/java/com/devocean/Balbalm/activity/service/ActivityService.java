package com.devocean.Balbalm.activity.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.devocean.Balbalm.activity.entity.dto.ActivityDto;
import com.devocean.Balbalm.calendar.dto.WalkingDayDto;
import com.devocean.Balbalm.walk.entity.Walk;
import com.devocean.Balbalm.walk.repository.WalkRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ActivityService {
	private final WalkRepository walkRepository;

	public List<ActivityDto> getActivities(String user_id, LocalDate date) {
		LocalDateTime startOfDay = date.atStartOfDay();
		LocalDateTime endOfDay = date.atTime(LocalTime.MAX);

		List<Walk> walks = walkRepository.findByCreatedTimeBetweenAndUserId(startOfDay, endOfDay, user_id);
		return walks.stream()
			.map(walk -> ActivityDto.of(walk))
			.collect(Collectors.toList());
	}

	public List<WalkingDayDto> getActivitiesInMonth(String user_id, int year, int month) {
		List<WalkingDayDto> walkingDayDtos = new ArrayList<>();
		for(int i=1; i<=31; i++) {
			walkingDayDtos.add(new WalkingDayDto(i, false));
		}

		List<Integer> walkingDay = walkRepository.findByYearAndMonth(year, month, user_id)
			.stream().map(walk -> walk.getCreatedTime().getDayOfMonth()).collect(Collectors.toList());
		for(int day : walkingDay) {
			walkingDayDtos.get(day-1).changeState();
		}

		return walkingDayDtos;
	}
}
