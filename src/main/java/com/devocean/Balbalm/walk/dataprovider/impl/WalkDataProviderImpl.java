package com.devocean.Balbalm.walk.dataprovider.impl;

import com.devocean.Balbalm.walk.dataprovider.WalkDataProvider;
import com.devocean.Balbalm.walk.domain.WalkDomain;
import com.devocean.Balbalm.walk.domain.WalkRankDomain;
import com.devocean.Balbalm.walk.entity.Walk;
import com.devocean.Balbalm.walk.repository.WalkRepository;
import com.devocean.Balbalm.walk.usecase.SaveWalkUseCase;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class WalkDataProviderImpl implements WalkDataProvider {

    private final WalkRepository walkRepository;

    @Override
    public void saveWalk(WalkDomain walkDomain) {
        walkRepository.save(WalkDataProviderImplMapper.MAPPER.toEntity(walkDomain));
    }

    @Override
    public List<WalkDomain> getWalkRank(LocalDate startDate, LocalDate endDate) {
        return WalkDataProviderImplMapper.MAPPER.toDomain(walkRepository.findByCreatedTimeBetween(startDate, endDate));
    }

    @Mapper
    public interface WalkDataProviderImplMapper {
        WalkDataProviderImpl.WalkDataProviderImplMapper MAPPER = Mappers.getMapper(WalkDataProviderImpl.WalkDataProviderImplMapper.class);
        Walk toEntity(WalkDomain walkDomain);
        List<WalkDomain> toDomain(List<Walk> walk);
    }
}
