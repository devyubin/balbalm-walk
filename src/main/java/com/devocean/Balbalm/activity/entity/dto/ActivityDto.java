package com.devocean.Balbalm.activity.entity.dto;

import java.time.Duration;

import com.devocean.Balbalm.activity.entity.Activity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ActivityDto {
	private String date;
	private String time;
	private double distance;
	private int kcal;

	public static ActivityDto of(Activity activity) {
		return ActivityDto.builder()
			.date(activity.getDate().toString())
			.time(formatDuration(activity.getTime()))
			.distance(activity.getDistance())
			.kcal(activity.getKcal())
			.build();
	}

	public static String formatDuration(Duration duration) {
		long hours = duration.toHours();
		long minutes = duration.toMinutesPart();
		long seconds = duration.toSecondsPart();

		return String.format("%02d:%02d:%02d", hours, minutes, seconds);
	}
}
