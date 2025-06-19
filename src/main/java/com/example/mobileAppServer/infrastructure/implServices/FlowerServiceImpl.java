package com.example.mobileAppServer.infrastructure.implServices;

import com.example.mobileAppServer.domain.entity.FlowerEntity;
import com.example.mobileAppServer.domain.exception.FlowerNotFoundException;
import com.example.mobileAppServer.domain.repository.FlowerRepository;
import com.example.mobileAppServer.domain.service.FlowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlowerServiceImpl implements FlowerService{

    private final FlowerRepository flowerRepository;

    @Override
    public FlowerEntity findByName(String name) {
        return flowerRepository.findByName(name)
                .orElseThrow(() -> new FlowerNotFoundException("Flower Not Found"));
    }
}
