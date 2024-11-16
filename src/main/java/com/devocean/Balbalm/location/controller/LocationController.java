package com.devocean.Balbalm.location.controller;

import com.devocean.Balbalm.global.exception.CommonResponse;
import com.devocean.Balbalm.location.usecase.GetWeatherUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
public class LocationController {
    private final GetWeatherUseCase getWeatherUseCase;

    @GetMapping("/weather")
    public CommonResponse<GetWeatherUseCase.Result> getWeather(@RequestParam("latitude") double latitude, @RequestParam("longitude") double longitude) {
        return new CommonResponse<>(getWeatherUseCase.execute(new GetWeatherUseCase.Command(latitude, longitude)));
    }
}
