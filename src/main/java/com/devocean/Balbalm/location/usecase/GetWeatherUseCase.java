package com.devocean.Balbalm.location.usecase;

import com.devocean.Balbalm.global.UseCase;
import com.devocean.Balbalm.location.dataprovider.LocationDataProvider;
import com.devocean.Balbalm.location.domain.WeatherDomain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;

@Slf4j
@Component
@RequiredArgsConstructor
public class GetWeatherUseCase implements UseCase<GetWeatherUseCase.Command, GetWeatherUseCase.Result> {

    private final LocationDataProvider locationDataProvider;

    @Override
    public Result execute(Command input) {
        WeatherDomain weather = locationDataProvider.getWeather(input.getLatitude(), input.getLongitude());
        return GetWeatherUseCaseMapper.MAPPER.toResult(weather);
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Command implements Serializable, UseCase.Command {
        @Serial
        private static final long serialVersionUID = 5536896870848166746L;

        private double latitude;
        private double longitude;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Result implements Serializable, UseCase.Result {
        @Serial
        private static final long serialVersionUID = -925566958797060381L;
        private String weather;
        private String detailWeather;
    }

    public interface GetWeatherUseCaseMapper {
        GetWeatherUseCase.GetWeatherUseCaseMapper MAPPER = Mappers.getMapper(GetWeatherUseCaseMapper.class);
        Result toResult(WeatherDomain weatherDomain);
    }
}
