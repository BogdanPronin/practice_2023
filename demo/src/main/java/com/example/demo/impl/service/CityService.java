package com.example.demo.impl.service;

import com.example.demo.api.dto.CityDTO;

import java.util.List;


import com.example.demo.domain.entity.City;
import com.example.demo.domain.repository.CityRepository;
import com.example.demo.impl.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    @Autowired
    public CityService(CityRepository cityRepository, CityMapper cityMapper) {
        this.cityRepository = cityRepository;
        this.cityMapper = cityMapper;
    }

    public CityDTO createCity(CityDTO cityDTO) {
        City city = cityMapper.cityDtoToCity(cityDTO);
        City savedCity = cityRepository.save(city);
        return cityMapper.cityToCityDto(savedCity);
    }

    public CityDTO getCityById(Long id) {
        City city = cityRepository.findById(id).orElse(null);
        return (city != null) ? cityMapper.cityToCityDto(city) : null;
    }

    public List<CityDTO> getAllCities() {
        List<City> cities = cityRepository.findAll();
        return cities.stream().map(cityMapper::cityToCityDto).collect(Collectors.toList());
    }

    public CityDTO updateCity(Long id, CityDTO updatedCityDTO) {
        City existingCity = cityRepository.findById(id).orElse(null);

        if (existingCity != null) {
            City updatedCity = cityMapper.cityDtoToCity(updatedCityDTO);
            updatedCity.setId(existingCity.getId());
            City savedCity = cityRepository.save(updatedCity);
            return cityMapper.cityToCityDto(savedCity);
        }

        return null;
    }

    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }
}


