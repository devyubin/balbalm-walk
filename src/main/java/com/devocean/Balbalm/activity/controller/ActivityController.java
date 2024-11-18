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
import com.devocean.Balbalm.global.exception.CommonResponse;
import com.devocean.Balbalm.global.util.JwtUtil;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/activity")
@RequiredArgsConstructor
public class ActivityController {
	private final ActivityService activityService;
	private final JwtUtil jwtUtil;

	@GetMapping()
	public CommonResponse<List<ActivityDto>> getActivity(
		@Parameter(description = "JWT token for authorization")
		@RequestHeader("Authorization") String token,
		@Parameter(description = "조회하고 싶은 날")
		@RequestParam LocalDate date) {
		return new CommonResponse<>(activityService.getActivities(jwtUtil.extractSocialId(token.substring(7)), date));
	}
}
