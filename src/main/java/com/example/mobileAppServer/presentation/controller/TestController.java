package com.example.mobileAppServer.presentation.controller;

import com.example.mobileAppServer.domain.entity.FlowerEntity;
import com.example.mobileAppServer.domain.service.PurchaseItemService;
import com.example.mobileAppServer.infrastructure.implServices.FlowerServiceImpl;
import com.example.mobileAppServer.infrastructure.implServices.PurchaseItemServiceImpl;
import com.example.mobileAppServer.presentation.controller.auth.dto.RegisterRequest;
import com.example.mobileAppServer.domain.entity.UserEntity;
import com.example.mobileAppServer.infrastructure.implServices.UserServiceImpl;
import com.example.mobileAppServer.presentation.controller.dto.FinishPurchaseRequest;
import com.example.mobileAppServer.presentation.controller.dto.FlowerRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {
    private final UserServiceImpl userService;
    private final FlowerServiceImpl flowerService;
    private final PurchaseItemServiceImpl purchaseItemService;

    @GetMapping("/email/{email}")
    public UserEntity findUserByEmail(@PathVariable String email){
        return userService.findByEmail(email);
    }

    @PostMapping("user/create")
    public ResponseEntity<UserEntity> createUser(@Valid @RequestBody RegisterRequest userRequest){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userRequest.getName());
        userEntity.setEmail(userRequest.getEmail());
        userEntity.setPassword(userRequest.getPassword());
        userEntity.setRole(userRequest.getRole());

        UserEntity savedUser = userService.create(userEntity);

        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/fpr")
    public Integer createPurchase(@Valid @RequestBody FinishPurchaseRequest finishPurchaseRequest){
        return purchaseItemService.finishPurchase(finishPurchaseRequest);
    }
}
