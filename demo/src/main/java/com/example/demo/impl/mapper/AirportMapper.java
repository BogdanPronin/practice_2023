package com.example.demo.impl.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.api.dto.AirportDTO;
import com.example.demo.domain.entity.Airport;

@Mapper(componentModel = "spring")
public interface AirportMapper {

    @Mapping(source = "city.id", target = "cityId")
    AirportDTO airportToAirportDto(Airport airport);

    @Mapping(source = "cityId", target = "city.id")
    Airport airportDtoToAirport(AirportDTO airportDTO);
}
