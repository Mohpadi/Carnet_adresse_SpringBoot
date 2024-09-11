package com.example.carnet_adresse.repository;

import com.example.carnet_adresse.model.Carnet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarnetRepo extends JpaRepository<Carnet, Long> {
}
