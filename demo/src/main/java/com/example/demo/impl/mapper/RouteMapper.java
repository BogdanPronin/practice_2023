package com.example.demo.impl.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.demo.api.dto.RouteDTO;
import com.example.demo.domain.entity.Route;

@Mapper(componentModel = "spring")
public interface RouteMapper {

    RouteMapper INSTANCE = Mappers.getMapper(RouteMapper.class);

    @Mapping(source = "departureAirport.id", target = "departureAirportId")
    @Mapping(source = "destinationAirport.id", target = "destinationAirportId")
    RouteDTO routeToRouteDto(Route route);

    @Mapping(source = "departureAirportId", target = "departureAirport.id")
    @Mapping(source = "destinationAirportId", target = "destinationAirport.id")
    Route routeDtoToRoute(RouteDTO routeDTO);
}
