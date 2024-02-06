package com.example.demo.impl.service;

import java.util.List;

import com.example.demo.impl.mapper.AirportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.api.dto.AirportDTO;
import com.example.demo.domain.entity.Airport;
import com.example.demo.domain.repository.AirportRepository;

@Service
public class AirportService {

    private final AirportRepository airportRepository;
    private final AirportMapper airportMapper;

    @Autowired
    public AirportService(AirportRepository airportRepository, AirportMapper airportMapper) {
        this.airportRepository = airportRepository;
        this.airportMapper = airportMapper;
    }

    public AirportDTO createAirport(AirportDTO airportDTO) {
        Airport airport = airportMapper.airportDtoToAirport(airportDTO);
        Airport savedAirport = airportRepository.save(airport);
        return airportMapper.airportToAirportDto(savedAirport);
    }

    public AirportDTO getAirportById(Long id) {
        Airport airport = airportRepository.findById(id).orElse(null);
        return (airport != null) ? airportMapper.airportToAirportDto(airport) : null;
    }

    public List<AirportDTO> getAllAirports() {
        List<Airport> airports = airportRepository.findAll();
        return airports.stream().map(airportMapper::airportToAirportDto).toList();
    }

    public AirportDTO updateAirport(Long id, AirportDTO updatedAirportDTO) {
        Airport existingAirport = airportRepository.findById(id).orElse(null);

        if (existingAirport != null) {
            Airport updatedAirport = airportMapper.airportDtoToAirport(updatedAirportDTO);
            updatedAirport.setId(existingAirport.getId());
            Airport savedAirport = airportRepository.save(updatedAirport);
            return airportMapper.airportToAirportDto(savedAirport);
        }

        return null;
    }

    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);
    }
}
