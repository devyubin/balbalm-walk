package com.devocean.Balbalm.walk.dataprovider.impl;

import com.devocean.Balbalm.walk.dataprovider.UserDataProvider;
import com.devocean.Balbalm.walk.domain.UserDomain;
import com.devocean.Balbalm.walk.entity.User;
import com.devocean.Balbalm.walk.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDataProviderImpl implements UserDataProvider {

    private final UserRepository userRepository;

    @Override
    public UserDomain getUserInfo(String userId) {
        return UserDataProviderImplMapper.MAPPER.toDomain(userRepository.findByUserId(userId).orElseGet(User::new));
    }

    @Mapper
    public interface UserDataProviderImplMapper {
        UserDataProviderImpl.UserDataProviderImplMapper MAPPER = Mappers.getMapper(UserDataProviderImpl.UserDataProviderImplMapper.class);
        UserDomain toDomain(User user);
    }
}
