package com.example.demo.api.controller;

import com.example.demo.api.dto.ScoreBoardDTO;
import com.example.demo.api.dto.TicketDTO;
import com.example.demo.impl.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/search")
    public ResponseEntity<List<TicketDTO>> searchFlights(
            @RequestParam(name = "sourceCity") String sourceCity,
            @RequestParam(name = "hoursAhead") int hoursAhead
    ) {
        List<TicketDTO> availableTickets = flightService.findAvailableTickets(sourceCity, hoursAhead);

        return ResponseEntity.ok(availableTickets);
    }
//    @GetMapping("/scoreboard")
//    public ResponseEntity<Set<ScoreBoardDTO>> getFlightsByAirportAndTime(
//            @RequestParam(name = "airportName") String airportName
//    ) {
//        Set<ScoreBoardDTO> scoreBoard = flightService.getFlightsByAirportAndTime(airportName);
//
//        return ResponseEntity.ok(scoreBoard);
//    }

}
