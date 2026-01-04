package com.example.fueldispensersystem.data.repositories;

import com.example.fueldispensersystem.data.models.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelRepository extends JpaRepository<Fuel, Long> {

}
