package com.example.mobileAppServer.domain.repository;

import com.example.mobileAppServer.domain.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
}
