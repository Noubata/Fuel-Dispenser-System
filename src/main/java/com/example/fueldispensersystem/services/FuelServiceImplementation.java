package com.example.fueldispensersystem.services;

import com.example.fueldispensersystem.data.models.Fuel;
import com.example.fueldispensersystem.data.models.Transactions;
import com.example.fueldispensersystem.data.repositories.FuelRepository;
import com.example.fueldispensersystem.data.repositories.TransactionsRepository;
import com.example.fueldispensersystem.dtos.requests.*;
import com.example.fueldispensersystem.dtos.responses.*;
import com.example.fueldispensersystem.utils.FuelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class FuelServiceImplementation implements FuelService {

    @Autowired
     FuelRepository fuelRepository;
    @Autowired
    TransactionsRepository transactionRepository;

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
    @Override
    public DispenseFuelByAmountResponse dispenseFuelByAmount(DispenseFuelByAmountRequest request) {
        Fuel fuel = fuelRepository.findByFuelType(request.getFuelType());
        if (fuel == null) {
            throw new IllegalArgumentException("Fuel type not found: " + request.getFuelType());
        }
        double litersToDispense = request.getAmount() / fuel.getPricePerLiter();
        if (fuel.getQuantity() < litersToDispense) {
            throw new IllegalArgumentException("Insufficient fuel. Available: " + fuel.getQuantity() + " liters");
        }
        fuel.setQuantity(fuel.getQuantity() - litersToDispense);
        Fuel updatedFuel = fuelRepository.save(fuel);

        Transactions transaction = new Transactions();
        transaction.setFuelType(request.getFuelType());
        transaction.setLitersDispensed(litersToDispense);
        transaction.setAmountPaid(request.getAmount());
        transaction.setAttendantId(request.getAttendantId());
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setTransactionType("BY_AMOUNT");
        transactionRepository.save(transaction);

        return FuelMapper.toDispenseFuelByAmountResponse(updatedFuel, request.getAmount(), litersToDispense);
    }
    @Override
    public DispenseFuelByLitersResponse dispenseFuelByLiters(DispenseFuelByLitersRequest request) {
        Fuel fuel = fuelRepository.findByFuelType(request.getFuelType());

        if (fuel == null) {
            throw new IllegalArgumentException("Fuel type not found: " + request.getFuelType());
        }
        if (fuel.getQuantity() < request.getLiters()) {
            throw new IllegalArgumentException("Insufficient fuel. Available: " + fuel.getQuantity() + " liters");
        }
        double totalCost = request.getLiters() * fuel.getPricePerLiter();
        fuel.setQuantity(fuel.getQuantity() - request.getLiters());
        Fuel updatedFuel = fuelRepository.save(fuel);
        Transactions transaction = new Transactions();
        transaction.setFuelType(request.getFuelType());
        transaction.setLitersDispensed(request.getLiters());
        transaction.setAmountPaid(totalCost);
        transaction.setAttendantId(request.getAttendantId());
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setTransactionType("BY_LITERS");
        transactionRepository.save(transaction);
        return FuelMapper.toDispenseFuelByLitersResponse(updatedFuel, request.getLiters(), totalCost);
    }
    @Override
    public ShowTransactionsResponse showTransactions() {
        List<Transactions> transactions = transactionRepository.findAll();
        return FuelMapper.toGetAllTransactionsResponse(transactions);
    }
}
