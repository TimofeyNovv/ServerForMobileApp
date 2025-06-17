package com.example.mobileAppServer.service;

import com.example.mobileAppServer.entity.UserEntity;


public interface UserService {
    public UserEntity findByEmail(String email);

    public UserEntity create(UserEntity userEntity);
}
