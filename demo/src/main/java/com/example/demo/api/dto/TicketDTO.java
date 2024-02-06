package com.example.demo.api.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Objects;

public class TicketDTO {
    private Long id;
    private Long routeId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime departureTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime arrivalTime;
    private Double price;
    private String seat;

    public TicketDTO() {
    }

    public TicketDTO(Long id, Long routeId, LocalDateTime departureTime, LocalDateTime arrivalTime, Double price, String seat) {
        this.id = id;
        this.routeId = routeId;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.seat = seat;
    }

    public TicketDTO(Long routeId, LocalDateTime departureTime, LocalDateTime arrivalTime, Double price, String seat) {
        this.routeId = routeId;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.seat = seat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketDTO ticketDTO = (TicketDTO) o;
        return Objects.equals(id, ticketDTO.id) && Objects.equals(routeId, ticketDTO.routeId) && Objects.equals(departureTime, ticketDTO.departureTime) && Objects.equals(arrivalTime, ticketDTO.arrivalTime) && Objects.equals(price, ticketDTO.price) && Objects.equals(seat, ticketDTO.seat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, routeId, departureTime, arrivalTime, price, seat);
    }

    @Override
    public String toString() {
        return "TicketDTO{" +
                "id=" + id +
                ", routeId=" + routeId +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", price=" + price +
                ", seat='" + seat + '\'' +
                '}';
    }
}
