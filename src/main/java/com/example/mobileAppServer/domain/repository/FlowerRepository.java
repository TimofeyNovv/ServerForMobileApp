package com.example.mobileAppServer.domain.repository;


import com.example.mobileAppServer.domain.entity.FlowerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlowerRepository extends JpaRepository<FlowerEntity, Integer> {

    Optional<FlowerEntity> findByName(String name);

}
