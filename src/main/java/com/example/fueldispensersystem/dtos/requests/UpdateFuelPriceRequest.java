package com.example.fueldispensersystem.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateFuelPriceRequest {
    private String fuelType;
    private double newPrice;
    private String attendantId;
}
