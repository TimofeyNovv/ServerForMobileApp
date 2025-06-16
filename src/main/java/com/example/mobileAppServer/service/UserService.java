package com.example.mobileAppServer.service;

import com.example.mobileAppServer.controller.dto.UserRequest;
import com.example.mobileAppServer.entity.UserEntity;
import com.example.mobileAppServer.entity.UserRole;


public interface UserService {
    public UserEntity findByEmail(String email);

    public UserEntity create(UserEntity userEntity);
}
