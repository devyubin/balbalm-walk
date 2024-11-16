package com.devocean.Balbalm.calendar.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WalkingDayDto {
	private int day;
	private boolean isWalkingDay;
}
