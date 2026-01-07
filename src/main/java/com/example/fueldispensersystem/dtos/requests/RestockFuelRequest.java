package com.example.fueldispensersystem.dtos.requests;

public class RestockFuelRequest {
    private String fuelType;
    private int quantityToAdd;
    private String attenantId;

    public RestockFuelRequest(String fuelType, int quantityToAdd, String attendantId) {
        this.fuelType = fuelType;
        this.quantityToAdd = quantityToAdd;
        this.attenantId = attendantId;
    }
    public int getQuantityToAdd() {
        return quantityToAdd;
    }
    public String getFuelType() {
        return fuelType;
    }
    public String getAttenantId() {
        return attenantId;
    }
}
