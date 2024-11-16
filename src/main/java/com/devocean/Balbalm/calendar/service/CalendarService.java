package com.devocean.Balbalm.calendar.service;

import java.time.LocalDate;
import java.time.YearMonth;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devocean.Balbalm.calendar.dto.resp.CalendarResponseDto;
import com.devocean.Balbalm.global.exception.BalbalmException;
import com.devocean.Balbalm.global.exception.ErrorCode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CalendarService {

	@Transactional(readOnly = true)
	public CalendarResponseDto getCalendarInfo(int year, int month) {
		validateMonth(month);

		YearMonth yearMonth = YearMonth.of(year, month);
		LocalDate firstDay = yearMonth.atDay(1);

		return CalendarResponseDto.builder()
			.year(year)
			.month(month)
			.totalWalkingDays(0) // 추후 산책 여부 추가
			.firstDayOfWeek(firstDay.getDayOfWeek().getValue())
			.build();
	}

	// === 편의 메서드 ===
	private void validateMonth(int month) {
		if (month < 1 || month > 12) {
			throw new BalbalmException(ErrorCode.INVALID_MONTH);
		}
	}
}