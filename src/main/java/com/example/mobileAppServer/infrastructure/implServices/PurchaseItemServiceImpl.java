package com.example.mobileAppServer.infrastructure.implServices;

import com.example.mobileAppServer.domain.entity.FlowerEntity;
import com.example.mobileAppServer.domain.entity.OrderEntity;
import com.example.mobileAppServer.domain.entity.PurchaseItemEntity;
import com.example.mobileAppServer.domain.repository.OrderRepository;
import com.example.mobileAppServer.domain.repository.PurchaseItemRepository;
import com.example.mobileAppServer.domain.service.PurchaseItemService;
import com.example.mobileAppServer.presentation.controller.dto.FinishPurchaseRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class PurchaseItemServiceImpl implements PurchaseItemService {

    private final UserServiceImpl userService;

    private final FlowerServiceImpl flowerService;

    private final PurchaseItemRepository purchaseItemRepository;

    private final OrderRepository orderRepository;

    @Override
    @Transactional()
    public Integer finishPurchase(FinishPurchaseRequest request) {
        log.info("create order entity from request: {}", request);

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUserEntity(userService.findByEmail(request.getEmail()));

        orderEntity.setComment(request.getComment());
        orderRepository.save(orderEntity);

        for (Map.Entry<Integer, Integer> entry : request.getFlowerIdAndCount().entrySet()) {
            Integer id = entry.getKey();
            Integer count = entry.getValue();

            FlowerEntity flowerEntity = flowerService.findById(id);
            PurchaseItemEntity purchaseItemEntity = new PurchaseItemEntity();
            purchaseItemEntity.setFlowerEntity(flowerEntity);
            purchaseItemEntity.setCount(count);
            purchaseItemEntity.setOrderEntity(orderEntity);
            purchaseItemRepository.save(purchaseItemEntity);

        }
        return orderEntity.getId();
    }
}
