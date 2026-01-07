package com.example.fueldispensersystem.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RestockFuelResponse {
    private String message;
    private String fuelType;
    private double newQuantity;
}
