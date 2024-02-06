package com.example.demo.impl.service;

import com.example.demo.domain.repository.RouteRepository;
import com.example.demo.impl.mapper.RouteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.api.dto.RouteDTO;
import com.example.demo.domain.entity.Route;

@Service
public class RouteService {

    private final RouteRepository routeRepository;
    private final RouteMapper routeMapper;

    @Autowired
    public RouteService(RouteRepository routeRepository, RouteMapper routeMapper) {
        this.routeRepository = routeRepository;
        this.routeMapper = routeMapper;
    }

    public RouteDTO createRoute(RouteDTO routeDTO) {
        Route route = routeMapper.routeDtoToRoute(routeDTO);
        Route savedRoute = routeRepository.save(route);
        return routeMapper.routeToRouteDto(savedRoute);
    }

    public RouteDTO getRouteById(Long id) {
        Route route = routeRepository.findById(id).orElse(null);
        return (route != null) ? routeMapper.routeToRouteDto(route) : null;
    }

    public List<RouteDTO> getAllRoutes() {
        List<Route> routes = routeRepository.findAll();
        return routes.stream().map(routeMapper::routeToRouteDto).collect(Collectors.toList());
    }

    public RouteDTO updateRoute(Long id, RouteDTO updatedRouteDTO) {
        Route existingRoute = routeRepository.findById(id).orElse(null);

        if (existingRoute != null) {
            Route updatedRoute = routeMapper.routeDtoToRoute(updatedRouteDTO);
            updatedRoute.setId(existingRoute.getId());
            Route savedRoute = routeRepository.save(updatedRoute);
            return routeMapper.routeToRouteDto(savedRoute);
        }

        return null;
    }

    public void deleteRoute(Long id) {
        routeRepository.deleteById(id);
    }
}
