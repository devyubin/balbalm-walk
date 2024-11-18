package com.devocean.Balbalm.walk.dataprovider;

import com.devocean.Balbalm.walk.domain.WalkDomain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface WalkDataProvider {
    void saveWalk(WalkDomain walkDomain);
    List<WalkDomain> getWalkRank(LocalDateTime startDate, LocalDateTime endDate);
}
