package com.example.fueldispensersystem.dtos.responses;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CalculateResponse {
    private String message;
    private String fuelType;
    private Double totalCost;
    private Double totalLiters;
    private double pricePerLiter;
}