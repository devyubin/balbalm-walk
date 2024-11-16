package com.devocean.Balbalm.location.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
public class WeatherDomain {
    private String weather;
    private String detailWeather;
}
