package com.example.mobileAppServer.domain.service;


import com.example.mobileAppServer.presentation.controller.dto.FinishPurchaseRequest;

public interface PurchaseItemService {

    Integer finishPurchase(FinishPurchaseRequest request);

}
