package com.example.mobileAppServer.presentation.controller.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Map;

@Data
public class FinishPurchaseRequest {

    @NotNull
    private Map<Integer, Integer> flowerIdAndCount;

    @NotEmpty
    private String name;

    @NotEmpty
    private String email;

    @NotEmpty
    private String comment;

}
