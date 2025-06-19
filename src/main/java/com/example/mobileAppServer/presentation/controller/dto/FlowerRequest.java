package com.example.mobileAppServer.presentation.controller.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlowerRequest {

    @NotEmpty
    private String image;

    @NotEmpty
    private String name;

    @NotNull
    private Double price;

    @NotNull
    private Double rating;
}
