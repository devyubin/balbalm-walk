package com.devocean.Balbalm.calendar.controller;

import com.devocean.Balbalm.calendar.dto.resp.CalendarResponseDto;
import com.devocean.Balbalm.calendar.service.CalendarService;
import com.devocean.Balbalm.global.exception.CommonResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calendar")
@RequiredArgsConstructor
@Tag(name = "Calendar", description = "캘린더 정보 조회 API")
public class CalendarController {

	private final CalendarService calendarService;

	@GetMapping
	@Operation(summary = "캘린더 조회", description = "연도와 월을 기준으로 캘린더 정보를 조회합니다.")
	public CommonResponse<CalendarResponseDto> getCalendar(
		@RequestParam int year,
		@RequestParam int month) {
		return new CommonResponse<>(calendarService.getCalendarInfo(year, month));
	}
}