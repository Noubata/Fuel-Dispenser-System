package com.example.fueldispensersystem.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculateRequest {
    private String fuelType;
    private Double amount;
    private Double liters;
}