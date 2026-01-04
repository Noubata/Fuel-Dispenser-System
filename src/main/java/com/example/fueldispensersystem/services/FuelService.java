package com.example.fueldispensersystem.services;

import com.example.fueldispensersystem.dtos.responses.GetAvailableFuelResponse;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface FuelService {
    Map<String,GetAvailableFuelResponse> getAvailableFuel();
}
