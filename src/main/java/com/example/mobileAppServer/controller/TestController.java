package com.example.mobileAppServer.controller;

import com.example.mobileAppServer.controller.dto.UserRequest;
import com.example.mobileAppServer.entity.UserEntity;
import com.example.mobileAppServer.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {
    private final UserServiceImpl userService;

    @GetMapping("/email/{email}")
    public UserEntity findUserByEmail(@PathVariable String email){
        return userService.findByEmail(email);
    }

    @PostMapping("user/create")
    public ResponseEntity<UserEntity> createUser(@Valid @RequestBody UserRequest userRequest){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userRequest.getName());
        userEntity.setEmail(userRequest.getEmail());
        userEntity.setPassword(userRequest.getPassword());
        userEntity.setRole(userRequest.getRole());

        UserEntity savedUser = userService.create(userEntity);

        return ResponseEntity.ok(savedUser);
    }
}
