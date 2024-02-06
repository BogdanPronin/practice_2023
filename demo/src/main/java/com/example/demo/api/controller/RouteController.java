package com.example.demo.api.controller;

import com.example.demo.impl.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.demo.api.dto.RouteDTO;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    private final RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping
    public ResponseEntity<RouteDTO> createRoute(@RequestBody RouteDTO routeDTO) {
        RouteDTO createdRoute = routeService.createRoute(routeDTO);
        return ResponseEntity.ok(createdRoute);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RouteDTO> getRouteById(@PathVariable Long id) {
        RouteDTO route = routeService.getRouteById(id);
        return (route != null) ? ResponseEntity.ok(route) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<RouteDTO>> getAllRoutes() {
        List<RouteDTO> routes = routeService.getAllRoutes();
        return ResponseEntity.ok(routes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RouteDTO> updateRoute(@PathVariable Long id, @RequestBody RouteDTO updatedRouteDTO) {
        RouteDTO route = routeService.updateRoute(id, updatedRouteDTO);
        return (route != null) ? ResponseEntity.ok(route) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoute(@PathVariable Long id) {
        routeService.deleteRoute(id);
        return ResponseEntity.noContent().build();
    }
}
