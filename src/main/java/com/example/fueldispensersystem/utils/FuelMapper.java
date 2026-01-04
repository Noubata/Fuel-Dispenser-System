package com.example.fueldispensersystem.utils;

import com.example.fueldispensersystem.data.models.Fuel;
import com.example.fueldispensersystem.dtos.responses.GetAvailableFuelResponse;

public class FuelMapper {

    public static GetAvailableFuelResponse toFuelResponse(Fuel fuel) {
        return new GetAvailableFuelResponse(
                fuel.getFuelName(),
                fuel.getPricePerLiter(),
                fuel.getQuantity()
        );
    }
}

