package com.devocean.Balbalm.dummy.usecase;

import com.devocean.Balbalm.dummy.dataprovider.DummyDataProvider;
import com.devocean.Balbalm.dummy.domain.GetDummyPlaceDomain;
import com.devocean.Balbalm.global.UseCase;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class GetDummyPlaceUseCase implements UseCase<GetDummyPlaceUseCase.Command, GetDummyPlaceUseCase.Result> {

    private final DummyDataProvider dummyDataProvider;
    @Override
    public Result execute(Command input) {
        return GetDummyPlaceUseCase.Result.builder()
                .list(DummyPlaceRecommendUseCaseMapper.MAPPER.toResult(dummyDataProvider.getDummyPlace()))
                .build();
    }

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Command implements Serializable, UseCase.Command {

    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Result implements Serializable, UseCase.Result {

        private List<Place> list;

        @Getter
        @Setter
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Place {
            private String name;
            private String category;
            private List<String> pictures;
            private double distance;
            private String address;
        }
    }

    @Mapper
    public interface DummyPlaceRecommendUseCaseMapper {
        GetDummyPlaceUseCase.DummyPlaceRecommendUseCaseMapper MAPPER = Mappers.getMapper(GetDummyPlaceUseCase.DummyPlaceRecommendUseCaseMapper.class);
        List<Result.Place> toResult(List<GetDummyPlaceDomain> getDummyPlaceDomain);
    }
}
