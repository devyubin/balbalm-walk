package com.devocean.Balbalm.calendar.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WalkingDayDto {
	private int date;
	private boolean hasWalking;
}
