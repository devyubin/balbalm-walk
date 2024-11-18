package com.devocean.Balbalm.location.controller;

import com.devocean.Balbalm.global.exception.CommonResponse;
import com.devocean.Balbalm.location.usecase.GetWeatherUseCase;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
@Tag(name = "Location", description = "위치 정보 조회 API")
public class LocationController {
    private final GetWeatherUseCase getWeatherUseCase;

    @GetMapping("/weather")
    @Operation(summary = "날씨 조회", description = "위도와 경도를 기준으로 날씨 정보를 조회합니다.")
    public CommonResponse<GetWeatherUseCase.Result> getWeather(@RequestParam("latitude") double latitude, @RequestParam("longitude") double longitude) {
        return new CommonResponse<>(getWeatherUseCase.execute(new GetWeatherUseCase.Command(latitude, longitude)));
    }
}
