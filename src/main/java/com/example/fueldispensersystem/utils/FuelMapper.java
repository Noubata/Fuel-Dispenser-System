package com.example.fueldispensersystem.utils;

import com.example.fueldispensersystem.data.models.Fuel;
import com.example.fueldispensersystem.dtos.requests.AddFuelRequest;
import com.example.fueldispensersystem.dtos.responses.AddFuelResponse;
import com.example.fueldispensersystem.dtos.responses.GetAvailableFuelResponse;
import com.example.fueldispensersystem.dtos.responses.RestockFuelResponse;
import com.example.fueldispensersystem.dtos.responses.UpdateFuelPriceResponse;

public class FuelMapper {

    public static GetAvailableFuelResponse toFuelResponse(Fuel fuel) {
        return new GetAvailableFuelResponse(fuel.getFuelName(), fuel.getPricePerLiter(), fuel.getQuantity());
    }

    public static Fuel toFuel(AddFuelRequest request) {
        return new Fuel(String.valueOf(request.getFuelType()), request.getPrice(), request.getQuantity());
    }

    public static AddFuelResponse toAddFuelResponse(Fuel savedFuel) {
        return new AddFuelResponse(
                "Fuel added successfully",
                savedFuel.getFuelName(),
                savedFuel.getQuantity(),
                savedFuel.getPricePerLiter()
        );
    }

    public static UpdateFuelPriceResponse toUpdateFuelPriceResponse(Fuel updatedFuel, double oldPrice) {
            return new UpdateFuelPriceResponse("Fuel price updated successfully");
    }
    public static RestockFuelResponse toRestockFuelResponse(Fuel fuel) {
        return new RestockFuelResponse(
                "Fuel restocked successfully",
                fuel.getFuelName(),
                fuel.getQuantity()
        );
    }
}

