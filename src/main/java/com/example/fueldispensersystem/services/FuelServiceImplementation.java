package com.example.fueldispensersystem.services;

import com.example.fueldispensersystem.dtos.responses.GetAvailableFuelResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FuelServiceImplementation implements FuelService {
    @Override
    public GetAvailableFuelResponse getAvailableFuel() {
        List<HashMap> dispensers =  new ArrayList<>();
    }
}
