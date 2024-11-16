package com.devocean.Balbalm.calendar.controller;

import com.devocean.Balbalm.calendar.dto.resp.CalendarResponseDto;
import com.devocean.Balbalm.calendar.service.CalendarService;
import com.devocean.Balbalm.global.exception.CommonResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calendar")
@RequiredArgsConstructor
public class CalendarController {

	private final CalendarService calendarService;

	@GetMapping
	public CommonResponse<CalendarResponseDto> getCalendar(
		@RequestParam int year,
		@RequestParam int month) {
		return new CommonResponse<>(calendarService.getCalendarInfo(year, month));
	}
}