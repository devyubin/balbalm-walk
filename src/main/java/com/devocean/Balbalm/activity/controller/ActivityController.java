package com.devocean.Balbalm.activity.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devocean.Balbalm.activity.entity.dto.ActivityDto;
import com.devocean.Balbalm.activity.service.ActivityService;
import com.devocean.Balbalm.calendar.dto.WalkingDayDto;
import com.devocean.Balbalm.global.exception.CommonResponse;
import com.devocean.Balbalm.global.util.JwtUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/activity")
@RequiredArgsConstructor
public class ActivityController {
	private final ActivityService activityService;
	private final JwtUtil jwtUtil;

	@GetMapping()
	public CommonResponse<List<ActivityDto>> getActivity(@RequestHeader("Authorization") String token, @RequestParam LocalDate date) {
		return new CommonResponse<>(activityService.getActivities(jwtUtil.extractSocialId(token.substring(7)), date));
	}

	@GetMapping("/month")
	public CommonResponse<List<WalkingDayDto>> getActivityDay(@RequestParam int month, @RequestParam int year, @RequestHeader("Authorization") String token) {
		return new CommonResponse<>(
			activityService.getActivitiesInMonth(
				jwtUtil.extractSocialId(token.substring(7)), year, month)
		);
	}
}
