package com.example.fueldispensersystem.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Fuel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fuelName;
    private double pricePerLiter;
    private int quantity;

//    protected Fuel() {
//    }
    public Fuel(String fuelName, double pricePerLiter, int quantity) {
        this.fuelName = fuelName;
        this.pricePerLiter = pricePerLiter;
        this.quantity = quantity;
    }
}
