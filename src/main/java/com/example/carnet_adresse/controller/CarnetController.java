package com.example.carnet_adresse.controller;

import com.example.carnet_adresse.model.Carnet;
import com.example.carnet_adresse.service.CarnetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carnets")
public class CarnetController {

    @Autowired
    private CarnetService carnetService;

    @GetMapping
    public List<Carnet> getAllCarnets() {
        return carnetService.getAllCarnets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carnet> getCarnetById(@PathVariable Long id) {
        Carnet carnet = carnetService.getCarnetById(id);
        if (carnet == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carnet);
    }

    @PostMapping
    public Carnet createCarnet(@RequestBody Carnet carnet) {
        return carnetService.saveCarnet(carnet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carnet> updateCarnet(@PathVariable Long id, @RequestBody Carnet carnetDetails) {
        Carnet carnet = carnetService.getCarnetById(id);
        if (carnet == null) {
            return ResponseEntity.notFound().build();
        }

        carnet.setNom(carnetDetails.getNom());
        carnet.setPrenom(carnetDetails.getPrenom());
        carnet.setNumero(carnetDetails.getNumero());
        carnet.setAdresse(carnetDetails.getAdresse());
        carnet.setPhoto(carnetDetails.getPhoto());

        Carnet updatedCarnet = carnetService.saveCarnet(carnet);
        return ResponseEntity.ok(updatedCarnet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarnet(@PathVariable Long id) {
        Carnet carnet = carnetService.getCarnetById(id);
        if (carnet == null) {
            return ResponseEntity.notFound().build();
        }

        carnetService.deleteCarnet(id);
        return ResponseEntity.noContent().build();
    }
}
