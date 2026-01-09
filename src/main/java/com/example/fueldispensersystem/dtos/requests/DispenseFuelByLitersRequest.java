package com.example.fueldispensersystem.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DispenseFuelByLitersRequest {
    private String fuelType;
    private double liters;
    private String attendantId;
}