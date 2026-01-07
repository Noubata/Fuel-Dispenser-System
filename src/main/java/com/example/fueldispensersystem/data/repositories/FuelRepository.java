package com.example.fueldispensersystem.data.repositories;

import com.example.fueldispensersystem.data.models.Fuel;
import com.example.fueldispensersystem.data.models.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelRepository extends JpaRepository<Fuel, Long> {
    boolean existsByFuelType(FuelType fuelName);
    Fuel findByFuelType(String fuelType);
}
