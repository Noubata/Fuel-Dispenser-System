package com.example.fueldispensersystem.services;

import com.example.fueldispensersystem.data.models.Fuel;
import com.example.fueldispensersystem.data.repositories.FuelRepository;
import com.example.fueldispensersystem.dtos.responses.GetAvailableFuelResponse;
import com.example.fueldispensersystem.utils.FuelMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FuelServiceImplementation implements FuelService {

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
}
