package com.example.mobileAppServer.presentation.controller;

import com.example.mobileAppServer.infrastructure.implServices.PurchaseItemServiceImpl;
import com.example.mobileAppServer.presentation.controller.dto.FinishPurchaseRequest;
import com.example.mobileAppServer.presentation.controller.dto.FinishPurchaseResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {

    private final PurchaseItemServiceImpl purchaseItemService;

    @PostMapping("/fpr")
    public ResponseEntity createPurchase(@Valid @RequestBody FinishPurchaseRequest finishPurchaseRequest){
        Integer orderId = purchaseItemService.finishPurchase(finishPurchaseRequest);
        return ResponseEntity.ok(new FinishPurchaseResponse(orderId));
    }
}
