package com.example.mobileAppServer.presentation.controller;

import com.example.mobileAppServer.infrastructure.implServices.PurchaseItemServiceImpl;
import com.example.mobileAppServer.infrastructure.implServices.UserServiceImpl;
import com.example.mobileAppServer.presentation.controller.dto.FinishPurchaseRequest;
import com.example.mobileAppServer.presentation.controller.dto.FinishPurchaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {

    private final PurchaseItemServiceImpl purchaseItemService;

    private final UserServiceImpl userService;

    @Operation(summary = "Create purchase")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Purchase created"),
    })
    @PostMapping("/fpr")
    public ResponseEntity createPurchase(@Valid @RequestBody FinishPurchaseRequest finishPurchaseRequest){
        Integer orderId = purchaseItemService.finishPurchase(finishPurchaseRequest);
        return ResponseEntity.ok(new FinishPurchaseResponse(orderId));
    }

    @Operation(summary = "Search User by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found"),
            @ApiResponse(responseCode = "403", description = "User not found")
    })
    @GetMapping("/user/{id}")
    public ResponseEntity getUserById(@PathVariable Integer id){
        return ResponseEntity.ok(userService.findById(id));
    }
}
