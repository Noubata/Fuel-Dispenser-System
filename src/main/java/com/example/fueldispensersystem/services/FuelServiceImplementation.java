package com.example.fueldispensersystem.services;

import com.example.fueldispensersystem.data.models.Fuel;
import com.example.fueldispensersystem.data.repositories.FuelRepository;
import com.example.fueldispensersystem.dtos.requests.AddFuelRequest;
import com.example.fueldispensersystem.dtos.requests.RestockFuelRequest;
import com.example.fueldispensersystem.dtos.requests.UpdateFuelPriceRequest;
import com.example.fueldispensersystem.dtos.responses.AddFuelResponse;
import com.example.fueldispensersystem.dtos.responses.GetAvailableFuelResponse;
import com.example.fueldispensersystem.dtos.responses.RestockFuelResponse;
import com.example.fueldispensersystem.dtos.responses.UpdateFuelPriceResponse;
import com.example.fueldispensersystem.utils.FuelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FuelServiceImplementation implements FuelService {

    @Autowired
    private final FuelRepository fuelRepository;
    public FuelServiceImplementation(FuelRepository fuelRepository){
        this.fuelRepository = fuelRepository;
    }
    @Override
    public Map<String, GetAvailableFuelResponse> getAvailableFuel() {
        List<Fuel> fuels = fuelRepository.findAll();
        Map<String, GetAvailableFuelResponse> allFuel = new LinkedHashMap<>();
        for (Fuel fuel : fuels) {
            GetAvailableFuelResponse response = FuelMapper.toFuelResponse(fuel);
            allFuel.put(fuel.getFuelName(), response);
        }
        return allFuel;
    }

    @Override
    public AddFuelResponse addFuel(AddFuelRequest request) {
        if (fuelRepository.existsByFuelType(request.getFuelType())) {
            throw new IllegalArgumentException("Fuel type already exists. Use restock to add quantity.");
        }
        Fuel fuel = FuelMapper.toFuel(request);
        Fuel savedFuel = fuelRepository.save(fuel);
        return FuelMapper.toAddFuelResponse(savedFuel);
    }
    @Override
    public UpdateFuelPriceResponse updateFuelPrice(UpdateFuelPriceRequest request) {
        Fuel fuel = fuelRepository.findByFuelType(request.getFuelType());

        if (fuel == null) {
            throw new IllegalArgumentException("Fuel type not found: " + request.getFuelType());
        }
        double oldPrice = fuel.getPricePerLiter();
        fuel.setPricePerLiter(request.getNewPrice());
        Fuel updatedFuel = fuelRepository.save(fuel);
        return FuelMapper.toUpdateFuelPriceResponse(updatedFuel, oldPrice);
    }
    @Override
    public RestockFuelResponse restockFuel(RestockFuelRequest request) {
        Fuel fuel = fuelRepository.findByFuelType(request.getFuelType());
        if (fuel == null) {
            throw new IllegalArgumentException("Fuel type not found: " + request.getFuelType());
        }
        fuel.setQuantity(fuel.getQuantity() + request.getQuantityToAdd());
        Fuel restockedFuel = fuelRepository.save(fuel);
        return FuelMapper.toRestockFuelResponse(restockedFuel);
    }
}
