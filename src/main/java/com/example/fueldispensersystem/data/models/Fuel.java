package com.example.fueldispensersystem.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Fuel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fuelName;
    private double pricePerLiter;
    private double quantity;
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    public Fuel(String fuelName, double pricePerLiter, int quantity) {
        this.fuelName = fuelName;
        this.pricePerLiter = pricePerLiter;
        this.quantity = quantity;
    }
}
