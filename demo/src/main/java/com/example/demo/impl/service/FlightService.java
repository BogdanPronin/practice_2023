package com.example.demo.impl.service;

import com.example.demo.api.dto.ScoreBoardDTO;
import com.example.demo.api.dto.TicketDTO;
import com.example.demo.domain.entity.Ticket;
import com.example.demo.domain.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
public class FlightService {

    @Autowired
    private TicketRepository ticketRepository;

    public List<TicketDTO> findAvailableTickets(String sourceCity, int hoursAhead) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime endTime = now.plusHours(hoursAhead);

        List<Ticket> availableTickets = ticketRepository.findAvailableTickets(sourceCity, now, endTime);

        // Преобразование списка билетов в список DTO
        List<TicketDTO> ticketDTOs = availableTickets.stream()
                .map(ticket -> new TicketDTO(
                        ticket.getId(),
                        ticket.getRoute().getId(),
                        ticket.getDepartureTime(),
                        ticket.getArrivalTime(),
                        ticket.getPrice(),
                        ticket.getSeat()
                ))
                .collect(Collectors.toList());

        return ticketDTOs;
    }

//    public Set<ScoreBoardDTO> getFlightsByAirportAndTime(String airportName) {
//        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime startTime = now;
//        LocalDateTime endTime = now.plusHours(24);
//        List<Ticket> availableTickets = ticketRepository.getFlightsByAirportAndTime(airportName, startTime, endTime);
//        Set<ScoreBoardDTO> scoreBoardDTOs = availableTickets.stream()
//                .map(ticket -> new ScoreBoardDTO(
//                        ticket.getRoute(),
//                        ticket.getDepartureTime(),
//                        ticket.getArrivalTime()
//                ))
//                .collect(Collectors.toSet());
//        return scoreBoardDTOs;
//    }
}

