package com.devocean.Balbalm.calendar.dto.resp;

import java.util.List;

import com.devocean.Balbalm.calendar.dto.WalkingDayDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CalendarResponseDto {
	private int year;
	private int month;
	private List<WalkingDayDto> walkingDays;
	private int totalWalkingDays;
	private int firstDayOfWeek;
}