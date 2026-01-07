package com.example.fueldispensersystem.serviceTest;

import com.example.fueldispensersystem.data.models.Fuel;
import com.example.fueldispensersystem.data.repositories.FuelRepository;
import com.example.fueldispensersystem.dtos.responses.GetAvailableFuelResponse;
import com.example.fueldispensersystem.services.FuelService;
import com.example.fueldispensersystem.services.FuelServiceImplementation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class FuelServiceImplementationTest {

    @Autowired
    private FuelRepository fuelRepository;
    @Autowired
    private FuelService fuelService;

    @Test
    public void testThatViewFuels() {
        assertEquals(0, fuelRepository.count());
        fuelRepository.save(new Fuel("Diesel", 500.0, 12));
        Map<String, GetAvailableFuelResponse> result = fuelService.getAvailableFuel();
        assertEquals(1, fuelRepository.count());
        assertTrue(result.containsKey("Diesel"));
    }
}
