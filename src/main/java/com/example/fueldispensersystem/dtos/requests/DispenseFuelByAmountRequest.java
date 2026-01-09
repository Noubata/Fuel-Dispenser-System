package com.example.fueldispensersystem.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DispenseFuelByAmountRequest {
    private String fuelType;
    private double amount;
    private String attendantId;
}