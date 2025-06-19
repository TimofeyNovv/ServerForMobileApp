package com.example.mobileAppServer.domain.service;

import com.example.mobileAppServer.domain.entity.FlowerEntity;

public interface FlowerService {

    FlowerEntity findByName(String name);
}
