package com.example.fueldispensersystem.dtos.requests;


import com.example.fueldispensersystem.data.models.FuelType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddFuelRequest {
    private FuelType fuelType;
    private int quantity;
    private int attendantId;
    private double price;
}
