package com.example.demo.domain.repository;

import com.example.demo.domain.entity.Airport;
import com.example.demo.domain.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query("SELECT t FROM Ticket t WHERE t.route.departureAirport.city.name = :sourceCity " +
            "AND t.departureTime BETWEEN :startTime AND :endTime")
    List<Ticket> findAvailableTickets(String sourceCity, LocalDateTime startTime, LocalDateTime endTime);

//    @Query("SELECT t FROM Ticket t " +
//            "JOIN FETCH t.route r " +
//            "WHERE (r.departureAirport.name = :airportName OR r.destinationAirport = :airportName) " +
//            "AND t.departureTime >= :startTime " +
//            "AND t.departureTime <= :endTime")
//    List<Ticket> getFlightsByAirportAndTime(String airportName, LocalDateTime startTime, LocalDateTime endTime);
}
