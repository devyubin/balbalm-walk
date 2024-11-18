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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/activity")
@RequiredArgsConstructor
@Tag(name = "Activity", description = "활동 정보 조회 API")
public class ActivityController {
	private final ActivityService activityService;
	private final JwtUtil jwtUtil;

	@GetMapping()
	@Operation(summary = "활동 조회", description = "JWT 토큰과 날짜를 기준으로 활동 정보를 조회합니다.")
	public CommonResponse<List<ActivityDto>> getActivity(
		@Parameter(description = "JWT token for authorization")
		@RequestHeader("Authorization") String token,
		@Parameter(description = "조회하고 싶은 날")
		@RequestParam LocalDate date) {
		return new CommonResponse<>(activityService.getActivities(jwtUtil.extractSocialId(token.substring(7)), date));
	}
}
