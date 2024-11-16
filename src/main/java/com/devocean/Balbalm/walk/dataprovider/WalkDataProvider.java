package com.devocean.Balbalm.walk.dataprovider;

import com.devocean.Balbalm.walk.domain.WalkDomain;
import com.devocean.Balbalm.walk.domain.WalkRankDomain;
import com.devocean.Balbalm.walk.domain.WalkRankUserDomain;

import java.time.LocalDate;
import java.util.List;

public interface WalkDataProvider {
    void saveWalk(WalkDomain walkDomain);
    List<WalkDomain> getWalkRank(LocalDate startDate, LocalDate endDate);
}
