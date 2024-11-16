package com.devocean.Balbalm.activity.entity.dto;


import com.devocean.Balbalm.activity.entity.Activity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ActivityDto {
	private String date;
	private int hours;
	private int minutes;
	private int seconds;
	private double distance;
	private int kcal;

	public static ActivityDto of(Activity activity) {
		return ActivityDto.builder()
			.date(activity.getDate().toString())
			.hours(activity.getHours())
			.minutes(activity.getMinutes())
			.seconds(activity.getSeconds())
			.distance(activity.getDistance())
			.kcal(activity.getKcal())
			.build();
	}
}
