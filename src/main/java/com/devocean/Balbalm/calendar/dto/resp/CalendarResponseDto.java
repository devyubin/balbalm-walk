package com.devocean.Balbalm.calendar.dto.resp;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CalendarResponseDto {
	private int year;
	private int month;
	private int totalWalkingDays;
	private int firstDayOfWeek;
}