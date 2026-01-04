package com.example.fueldispensersystem.data.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FuelAttendant {
    private String fullName;
    private Dispenser dispenser;
}
