package com.example.carnet_adresse.service;

import com.example.carnet_adresse.model.Carnet;
import com.example.carnet_adresse.repository.CarnetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarnetService {

    @Autowired
    private CarnetRepo carnetRepository;

    public List<Carnet> getAllCarnets() {
        return carnetRepository.findAll();
    }

    public Carnet getCarnetById(Long id) {
        return carnetRepository.findById(id).orElse(null);
    }

    public Carnet saveCarnet(Carnet carnet) {
        return carnetRepository.save(carnet);
    }

    public void deleteCarnet(Long id) {
        carnetRepository.deleteById(id);
    }
}
