package com.example.fueldispensersystem.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.lang.annotation.Documented;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Dispenser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private HashMap<String ,Fuel> fuels;

}
