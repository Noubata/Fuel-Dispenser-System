package com.example.fueldispensersystem.controllers;

import com.example.fueldispensersystem.dtos.requests.RestockFuelRequest;
import com.example.fueldispensersystem.dtos.responses.GetAvailableFuelResponse;
import com.example.fueldispensersystem.dtos.responses.RestockFuelResponse;
import com.example.fueldispensersystem.services.FuelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("./api/v1/fuel")
public class FuelServiceController {
    @Autowired
    private FuelService fuelService;

@GetMapping("/get-fuel")
public Map<String, GetAvailableFuelResponse> getAvailableFuel() {
    return fuelService.getAvailableFuel();
}



}
