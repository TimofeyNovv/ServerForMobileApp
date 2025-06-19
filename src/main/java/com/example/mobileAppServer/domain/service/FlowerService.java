package com.example.mobileAppServer.domain.service;

import com.example.mobileAppServer.domain.entity.FlowerEntity;
import com.example.mobileAppServer.presentation.controller.dto.FlowerRequest;

public interface FlowerService {

    FlowerEntity findByName(String name);

    FlowerEntity findById(Integer id);

    void create(FlowerRequest flowerRequest);
}
