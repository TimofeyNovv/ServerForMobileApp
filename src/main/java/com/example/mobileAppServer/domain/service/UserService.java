package com.example.mobileAppServer.domain.service;

import com.example.mobileAppServer.domain.entity.UserEntity;


public interface UserService {
    public UserEntity findByEmail(String email);

    public UserEntity findById(Integer id);

    public UserEntity create(UserEntity userEntity);
}
