package com.devocean.Balbalm.activity.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devocean.Balbalm.activity.entity.dto.ActivityDto;
import com.devocean.Balbalm.activity.service.ActivityService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/activity")
@RequiredArgsConstructor
public class ActivityController {
	private final ActivityService activityService;

	@GetMapping()
	public List<ActivityDto> getActivity(@RequestParam Long userId, @RequestParam LocalDate date) {
		return activityService.getActivities(date);
	}
}
