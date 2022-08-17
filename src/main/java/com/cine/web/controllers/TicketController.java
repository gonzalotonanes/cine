package com.cine.web.controllers;

import com.cine.domain.ticket.RequestTicketDto;
import com.cine.domain.ticket.Ticket;
import com.cine.domain.ticket.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }



    @PostMapping(consumes = "application/json")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<List<Ticket>> createTicket(@Valid @RequestBody RequestTicketDto dto){
        return new ResponseEntity<List<Ticket>>(ticketService.createTicket(dto), HttpStatus.CREATED);
    }

    private Ticket toTicket(RequestTicketDto dto){
        Ticket ticket= new Ticket();
        ticket.setIdFunction(dto.getFuncionid());
        ticket.setUser(dto.getUsuario());
        return  ticket;
    }
}
