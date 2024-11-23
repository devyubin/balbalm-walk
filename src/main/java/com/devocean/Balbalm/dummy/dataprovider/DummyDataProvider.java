package com.devocean.Balbalm.dummy.dataprovider;

import com.devocean.Balbalm.dummy.domain.GetDummyPlaceDomain;
import com.devocean.Balbalm.dummy.domain.SaveDummyPlaceDomain;

import java.util.List;

public interface DummyDataProvider {
    List<GetDummyPlaceDomain> getDummyPlace();
    void saveDummyPlace(List<SaveDummyPlaceDomain> list);
}
