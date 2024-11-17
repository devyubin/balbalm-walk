package com.devocean.Balbalm.location.dataprovider;

import com.devocean.Balbalm.location.domain.WeatherDomain;

public interface LocationDataProvider {
    WeatherDomain getWeather(double latitude, double longitude);
}
