package com.devocean.Balbalm.location.dataprovider.impl;

import com.devocean.Balbalm.external.weather.WeatherAPIRestClient;
import com.devocean.Balbalm.external.weather.response.WeatherResponse;
import com.devocean.Balbalm.global.config.ExternalApiProperties;
import com.devocean.Balbalm.location.dataprovider.LocationDataProvider;
import com.devocean.Balbalm.location.domain.WeatherDomain;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LocationDataProviderImpl implements LocationDataProvider {
    private final WeatherAPIRestClient weatherAPIRestClient;
    private final ExternalApiProperties externalApiProperties;

    @Override
    public WeatherDomain getWeather(double latitude, double longitude) {
        WeatherResponse weatherResponse = weatherAPIRestClient.analysisMailContent(latitude, longitude, externalApiProperties.getWeather().getApiKey());
        return LocationDataProviderImplMapper.MAPPER.toDomain(weatherResponse);
    }

    public interface LocationDataProviderImplMapper {
        LocationDataProviderImpl.LocationDataProviderImplMapper MAPPER = Mappers.getMapper(LocationDataProviderImpl.LocationDataProviderImplMapper.class);
        WeatherDomain toDomain(WeatherResponse weatherResponse);
    }
}
