package com.example.fueldispensersystem.dtos.responses;

import com.example.fueldispensersystem.data.models.Transactions;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShowTransactionsResponse {
    private String message;
    private List<Transactions> transactions;
}