package com.example.demo.api.controller;

import com.example.demo.api.dto.AirportDTO;
import com.example.demo.impl.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/airports")
public class AirportController {

    private final AirportService airportService;

    @Autowired
    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @PostMapping
    public ResponseEntity<AirportDTO> createAirport(@RequestBody AirportDTO airportDTO) {
        AirportDTO createdAirport = airportService.createAirport(airportDTO);
        return ResponseEntity.ok(createdAirport);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirportDTO> getAirportById(@PathVariable Long id) {
        AirportDTO airport = airportService.getAirportById(id);
        return (airport != null) ? ResponseEntity.ok(airport) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<AirportDTO>> getAllAirports() {
        List<AirportDTO> airports = airportService.getAllAirports();
        return ResponseEntity.ok(airports);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AirportDTO> updateAirport(@PathVariable Long id, @RequestBody AirportDTO updatedAirportDTO) {
        AirportDTO airport = airportService.updateAirport(id, updatedAirportDTO);
        return (airport != null) ? ResponseEntity.ok(airport) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable Long id) {
        airportService.deleteAirport(id);
        return ResponseEntity.noContent().build();
    }
}
