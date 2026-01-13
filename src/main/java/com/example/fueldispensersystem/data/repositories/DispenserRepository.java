package com.example.fueldispensersystem.data.repositories;

import com.example.fueldispensersystem.data.models.Dispenser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DispenserRepository extends JpaRepository<Dispenser, Long> {
}
