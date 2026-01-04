package com.example.fueldispensersystem.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetAvailableFuelResponse {
    private String Fuel;
    private double price;
}
