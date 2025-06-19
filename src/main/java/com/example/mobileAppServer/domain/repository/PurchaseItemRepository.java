package com.example.mobileAppServer.domain.repository;

import com.example.mobileAppServer.domain.entity.PurchaseItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseItemRepository extends JpaRepository<PurchaseItemEntity, Integer> {
}
