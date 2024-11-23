package com.devocean.Balbalm.dummy.usecase;

import com.devocean.Balbalm.dummy.dataprovider.DummyDataProvider;
import com.devocean.Balbalm.dummy.domain.GetDummyPlaceDomain;
import com.devocean.Balbalm.dummy.domain.SaveDummyPlaceDomain;
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
public class SaveDummyPlaceUseCase implements UseCase<SaveDummyPlaceUseCase.Command, SaveDummyPlaceUseCase.Result> {

    private final DummyDataProvider dummyDataProvider;

    @Override
    public Result execute(Command input) {
        dummyDataProvider.saveDummyPlace(SaveDummyPlaceUseCaseMapper.MAPPER.toDomain(input.getList()));
        return new Result();
    }

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Command implements Serializable, UseCase.Command {

        private List<Place> list;

        @Getter
        public static class Place {
            private String name;
            private String category;
            private String pictures;
            private double distance;
            private String address;
        }
    }

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Result implements Serializable, UseCase.Result {
    }

    @Mapper
    public interface SaveDummyPlaceUseCaseMapper {
        SaveDummyPlaceUseCase.SaveDummyPlaceUseCaseMapper MAPPER = Mappers.getMapper(SaveDummyPlaceUseCase.SaveDummyPlaceUseCaseMapper.class);
        List<SaveDummyPlaceDomain> toDomain(List<Command.Place> places);
    }
}
