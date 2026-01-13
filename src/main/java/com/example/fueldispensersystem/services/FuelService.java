package com.example.fueldispensersystem.services;

import com.example.fueldispensersystem.dtos.requests.*;
import com.example.fueldispensersystem.dtos.responses.*;
import org.springframework.stereotype.Service;

import java.util.Map;
public interface FuelService {
    Map<String,GetAvailableFuelResponse> getAvailableFuel();
    AddFuelResponse addFuel(AddFuelRequest request);
    UpdateFuelPriceResponse updateFuelPrice(UpdateFuelPriceRequest request);
    RestockFuelResponse restockFuel(RestockFuelRequest request);
    DispenseFuelByAmountResponse dispenseFuelByAmount(DispenseFuelByAmountRequest request);
    DispenseFuelByLitersResponse dispenseFuelByLiters(DispenseFuelByLitersRequest request);

    ShowTransactionsResponse showTransactions();
}