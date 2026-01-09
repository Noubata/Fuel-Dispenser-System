package com.example.fueldispensersystem.data.repositories;

import com.example.fueldispensersystem.data.models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository extends JpaRepository<Transactions, Long> {
}