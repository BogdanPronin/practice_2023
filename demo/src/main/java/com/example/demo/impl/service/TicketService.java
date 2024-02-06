package com.example.demo.impl.service;

import com.example.demo.impl.mapper.TicketMapper;
import com.example.demo.api.dto.TicketDTO;
import com.example.demo.domain.entity.Ticket;
import com.example.demo.domain.repository.TicketRepository;
import com.example.demo.impl.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;
    private static final Logger logger = LoggerFactory.getLogger(TicketService.class);

    @Autowired
    public TicketService(TicketRepository ticketRepository, TicketMapper ticketMapper) {
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
    }

    public TicketDTO getTicketById(Long id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Ticket not found"));
        return ticketMapper.ticketToTicketDto(ticket);
    }

    public List<TicketDTO> getAllTickets() {
        List<Ticket> tickets = ticketRepository.findAll();
        return ticketMapper.ticketToTicketDTOs(tickets);
    }

    public TicketDTO createTicket(TicketDTO ticketDTO) {
        // Логирование перед маппингом
        logger.info("Received TicketDTO: {}", ticketDTO);

        Ticket ticket = ticketMapper.ticketDtoToTicket(ticketDTO);

        // Логирование после маппинга
        logger.info("Mapped Ticket: {}", ticket);

        Ticket savedTicket = ticketRepository.save(ticket);
        return ticketMapper.ticketToTicketDto(savedTicket);
    }

    public TicketDTO updateTicket(Long id, TicketDTO ticketDTO) {
        Ticket existingTicket = ticketRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Ticket not found"));

        // Update existingTicket with data from ticketDTO

        Ticket updatedTicket = ticketRepository.save(existingTicket);
        return ticketMapper.ticketToTicketDto(updatedTicket);
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}

