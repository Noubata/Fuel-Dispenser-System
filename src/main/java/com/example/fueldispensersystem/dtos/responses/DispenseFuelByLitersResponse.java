package com.example.fueldispensersystem.dtos.responses;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DispenseFuelByLitersResponse {
    private String message;
    private String fuelType;
    private double litersDispensed;
    private double totalCost;
    private double pricePerLiter;
}