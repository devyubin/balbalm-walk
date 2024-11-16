package com.devocean.Balbalm.external.weather.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class WeatherResponse {
    private List<Weather> weather;
    @Getter
    public static class Weather {
        private long id;   // 800
        @JsonProperty("main")
        private String weather;   // Clear
        @JsonProperty("description")
        private String detailWeather;   // clear sky
        private String icon;   // 01n
    }
}
