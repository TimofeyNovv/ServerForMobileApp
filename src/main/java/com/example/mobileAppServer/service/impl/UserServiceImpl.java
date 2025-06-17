package com.example.mobileAppServer.service.impl;

import com.example.mobileAppServer.exception.UserNotFoundException;
import com.example.mobileAppServer.repository.UserRepository;
import com.example.mobileAppServer.entity.UserEntity;
import com.example.mobileAppServer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public UserEntity create(UserEntity userEntity) {
        userRepository.save(userEntity);
        return userEntity;
    }
}
