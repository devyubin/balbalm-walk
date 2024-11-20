package com.devocean.Balbalm.walk.dataprovider;

import com.devocean.Balbalm.walk.domain.UserDomain;

public interface UserDataProvider {
    UserDomain getUserInfo(String userId);
}
