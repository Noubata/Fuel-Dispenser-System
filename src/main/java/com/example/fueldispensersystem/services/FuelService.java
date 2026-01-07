package com.example.fueldispensersystem.services;

import com.example.fueldispensersystem.dtos.requests.AddFuelRequest;
import com.example.fueldispensersystem.dtos.requests.RestockFuelRequest;
import com.example.fueldispensersystem.dtos.requests.UpdateFuelPriceRequest;
import com.example.fueldispensersystem.dtos.responses.AddFuelResponse;
import com.example.fueldispensersystem.dtos.responses.GetAvailableFuelResponse;
import com.example.fueldispensersystem.dtos.responses.RestockFuelResponse;
import com.example.fueldispensersystem.dtos.responses.UpdateFuelPriceResponse;

import java.util.Map;

public interface FuelService {
    Map<String,GetAvailableFuelResponse> getAvailableFuel();
    AddFuelResponse addFuel(AddFuelRequest request);
    UpdateFuelPriceResponse updateFuelPrice(UpdateFuelPriceRequest request);
    RestockFuelResponse restockFuel(RestockFuelRequest request);
}