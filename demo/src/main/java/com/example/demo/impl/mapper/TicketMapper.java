package com.example.demo.impl.mapper;

import com.example.demo.api.dto.TicketDTO;
import com.example.demo.domain.entity.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);

    @Mappings({
            @Mapping(target = "route.id", source = "routeId"),
            @Mapping(target = "arrivalTime", source = "arrivalTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "departureTime", source = "departureTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    Ticket ticketDtoToTicket(TicketDTO ticketDTO);

    @Mappings({
            @Mapping(target = "routeId", source = "route.id"),
            @Mapping(target = "arrivalTime", source = "arrivalTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "departureTime", source = "departureTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    TicketDTO ticketToTicketDto(Ticket ticket);

    List<TicketDTO> ticketToTicketDTOs(List<Ticket> tickets);
}