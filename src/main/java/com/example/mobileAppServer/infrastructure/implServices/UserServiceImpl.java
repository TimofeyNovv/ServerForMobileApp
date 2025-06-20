package com.example.mobileAppServer.infrastructure.implServices;

import com.example.mobileAppServer.domain.entity.UserEntity;
import com.example.mobileAppServer.domain.exception.UserNotFoundException;
import com.example.mobileAppServer.domain.repository.UserRepository;
import com.example.mobileAppServer.domain.service.UserService;
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
    public UserEntity findById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User Not Found"));
    }

    @Override
    public UserEntity create(UserEntity userEntity) {
        userRepository.save(userEntity);
        return userEntity;
    }
}
