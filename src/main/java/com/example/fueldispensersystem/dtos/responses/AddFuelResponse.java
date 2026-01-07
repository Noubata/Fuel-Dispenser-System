package com.example.fueldispensersystem.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class AddFuelResponse {
    private String message;
    private String fuelType;
    private double quantity;
    private double price;
}
