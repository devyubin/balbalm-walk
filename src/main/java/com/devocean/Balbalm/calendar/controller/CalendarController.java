package com.devocean.Balbalm.calendar.controller;

import java.time.LocalDate;
import java.util.List;

import com.devocean.Balbalm.activity.service.ActivityService;
import com.devocean.Balbalm.calendar.dto.WalkingDayDto;
import com.devocean.Balbalm.calendar.dto.resp.CalendarResponseDto;
import com.devocean.Balbalm.calendar.service.CalendarService;
import com.devocean.Balbalm.global.exception.CommonResponse;
import com.devocean.Balbalm.global.util.JwtUtil;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calendar")
@RequiredArgsConstructor
@Tag(name = "Calendar", description = "캘린더 정보 조회 API")
public class CalendarController {

	private final CalendarService calendarService;
	private final ActivityService activityService;
	private final JwtUtil jwtUtil;

	@GetMapping
	@Operation(summary = "캘린더 조회", description = "연도와 월을 기준으로 캘린더 정보를 조회합니다.")
	public CommonResponse<CalendarResponseDto> getCalendar(
		@Parameter(description = "조회하는 연도")
		@RequestParam int year,
		@Parameter(description = "조회하는 월")
		@RequestParam int month,
		@RequestHeader("Authorization") String token) {

		List<WalkingDayDto> walkingDays = activityService.getActivitiesInMonth(
			jwtUtil.extractSocialId(token.substring(7)), year, month);

		LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
		int dayOfWeek = firstDayOfMonth.getDayOfWeek().getValue();

		return new CommonResponse<>(
			new CalendarResponseDto(year, month, walkingDays, walkingDays.size(), dayOfWeek)
		);
	}
}