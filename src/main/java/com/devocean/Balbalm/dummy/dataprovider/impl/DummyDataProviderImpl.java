package com.devocean.Balbalm.dummy.dataprovider.impl;

import com.devocean.Balbalm.dummy.dataprovider.DummyDataProvider;
import com.devocean.Balbalm.dummy.domain.GetDummyPlaceDomain;
import com.devocean.Balbalm.dummy.domain.SaveDummyPlaceDomain;
import com.devocean.Balbalm.dummy.entity.DummyPlaceRecommend;
import com.devocean.Balbalm.dummy.repository.DummyPlaceRecommendRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DummyDataProviderImpl implements DummyDataProvider {

    private final DummyPlaceRecommendRepository dummyPlaceRecommendRepository;

    @Override
    public List<GetDummyPlaceDomain> getDummyPlace() {
        List<DummyPlaceRecommend> placeList = dummyPlaceRecommendRepository.findAll();
        return placeList.stream()
                .map(place ->
                        GetDummyPlaceDomain.builder()
                                        .name(place.getName())
                                        .category(place.getCategory())
                                        .pictures(Arrays.asList(place.getPictures().split(",")))
                                        .distance(place.getDistance())
                                        .address(place.getAddress())
                                        .build()

                ).toList();
    }

    @Override
    public void saveDummyPlace(List<SaveDummyPlaceDomain> list) {
        dummyPlaceRecommendRepository.saveAll(DummyDataProviderImplMapper.MAPPER.toEntity(list));
    }

    @Mapper
    public interface DummyDataProviderImplMapper {
        DummyDataProviderImpl.DummyDataProviderImplMapper MAPPER = Mappers.getMapper(DummyDataProviderImplMapper.class);
        List<DummyPlaceRecommend> toEntity(List<SaveDummyPlaceDomain> list);
    }
}
