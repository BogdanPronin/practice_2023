package com.example.demo.api.dto;

import java.util.Objects;

public class RouteDTO {
    private Long id;
    private Long departureAirportId;
    private Long destinationAirportId;
    private Double distance;

    public RouteDTO() {
    }

    public RouteDTO(Long departureAirportId, Long destinationAirportId, Double distance) {
        this.departureAirportId = departureAirportId;
        this.destinationAirportId = destinationAirportId;
        this.distance = distance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDepartureAirportId() {
        return departureAirportId;
    }

    public void setDepartureAirportId(Long departureAirportId) {
        this.departureAirportId = departureAirportId;
    }

    public Long getDestinationAirportId() {
        return destinationAirportId;
    }

    public void setDestinationAirportId(Long destinationAirportId) {
        this.destinationAirportId = destinationAirportId;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteDTO routeDTO = (RouteDTO) o;
        return Objects.equals(id, routeDTO.id) && Objects.equals(departureAirportId, routeDTO.departureAirportId) && Objects.equals(destinationAirportId, routeDTO.destinationAirportId) && Objects.equals(distance, routeDTO.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departureAirportId, destinationAirportId, distance);
    }

    @Override
    public String toString() {
        return "RouteDTO{" +
                "id=" + id +
                ", departureAirportId=" + departureAirportId +
                ", destinationAirportId=" + destinationAirportId +
                ", distance=" + distance +
                '}';
    }
}

