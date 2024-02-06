package com.example.demo.domain.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "departure_airport_id", nullable = false)
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "destination_airport_id", nullable = false)
    private Airport destinationAirport;

    @Column(nullable = false)
    private Double distance;

    public Route() {
    }

    public Route(Airport departureAirport, Airport destinationAirport, Double distance) {
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.distance = distance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(Airport destinationAirport) {
        this.destinationAirport = destinationAirport;
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
        Route route = (Route) o;
        return Objects.equals(id, route.id) && Objects.equals(departureAirport, route.departureAirport) && Objects.equals(destinationAirport, route.destinationAirport) && Objects.equals(distance, route.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departureAirport, destinationAirport, distance);
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", departureAirport=" + departureAirport +
                ", destinationAirport=" + destinationAirport +
                ", distance=" + distance +
                '}';
    }
}
