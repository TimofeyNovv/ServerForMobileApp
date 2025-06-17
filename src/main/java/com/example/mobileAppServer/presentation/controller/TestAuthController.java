package com.example.mobileAppServer.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/demo")
@RequiredArgsConstructor
public class TestAuthController {

    @GetMapping
    public ResponseEntity<String> sayWork(){
        return ResponseEntity.ok("WORK!!!");
    }
}
