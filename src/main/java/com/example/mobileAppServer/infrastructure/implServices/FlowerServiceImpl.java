package com.example.mobileAppServer.infrastructure.implServices;

import com.example.mobileAppServer.domain.entity.FlowerEntity;
import com.example.mobileAppServer.domain.exception.FlowerNotFoundException;
import com.example.mobileAppServer.domain.repository.FlowerRepository;
import com.example.mobileAppServer.domain.service.FlowerService;
import com.example.mobileAppServer.presentation.controller.dto.FlowerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FlowerServiceImpl implements FlowerService{

    private final FlowerRepository flowerRepository;

    @Override
    @Transactional(readOnly = true)
    public FlowerEntity findByName(String name) {
        return flowerRepository.findByName(name)
                .orElseThrow(() -> new FlowerNotFoundException("Flower Not Found"));
    }

    @Override
    @Transactional(readOnly = true)
    public FlowerEntity findById(Integer id) {
        return flowerRepository.findById(id)
                .orElseThrow(() -> new FlowerNotFoundException("Flower not found"));
    }

    @Override
    @Transactional()
    public void create(FlowerRequest flowerRequest) {
        FlowerEntity flowerEntity = FlowerEntity.builder()
                .image(flowerRequest.getImage())
                .price(flowerRequest.getPrice())
                .name(flowerRequest.getName())
                .rating(flowerRequest.getRating())
                .build();
        flowerRepository.save(flowerEntity);
    }
}
