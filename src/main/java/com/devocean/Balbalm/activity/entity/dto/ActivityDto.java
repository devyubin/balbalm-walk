package com.devocean.Balbalm.activity.entity.dto;


import com.devocean.Balbalm.activity.entity.Activity;
import com.devocean.Balbalm.walk.entity.Walk;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ActivityDto {
	private long time;
	private double distance;
	private int kcal;

	public static ActivityDto of(Walk walk) {
		return ActivityDto.builder()
			.time(walk.getTime())
			.distance(walk.getDistance())
			.kcal(walk.getKcal())
			.build();
	}
}
