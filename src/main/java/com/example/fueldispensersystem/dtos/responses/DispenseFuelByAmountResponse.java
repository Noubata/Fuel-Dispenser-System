package com.example.fueldispensersystem.dtos.responses;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DispenseFuelByAmountResponse {
    private String message;
    private String fuelType;
    private double amountPaid;
    private double litersDispensed;
    private double pricePerLiter;
}