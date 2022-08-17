package com.cine.domain.ticket;

import com.cine.database.repositories.DefaultTicketRepository;
import com.cine.domain.exceptions.NotCapacityException;
import com.cine.domain.function.DefaultFunctionService;
import com.cine.domain.function.Function;
import com.cine.domain.theater.DefaultTheaterService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultTicketService implements TicketService{

    private DefaultTicketRepository defaultTicketRepository;
    private DefaultFunctionService defaultFunctionService;
    private DefaultTheaterService defaultTheaterService;

    public DefaultTicketService(DefaultTicketRepository defaultTicketRepository, DefaultFunctionService defaultFunctionService ,DefaultTheaterService defaultTheaterService) {

        this.defaultTicketRepository = defaultTicketRepository;
        this.defaultFunctionService= defaultFunctionService;
        this.defaultTheaterService = defaultTheaterService;
    }

    @Override
    public int countTicketByFunction(int id) {
        return defaultTicketRepository.countTicketByFunction(id);
    }

    @Override
    public List<Ticket> createTicket(RequestTicketDto ticketDto) {
        Function function = defaultFunctionService.findById(ticketDto.getFuncionid());
        System.out.println(function.getId());
        Ticket ticket = null;
        ticketDto.getFuncionid();
        List<Ticket> ticketList= new ArrayList<>();
        if (!checkAvailability(function, ticketDto.getCantidad())){
            throw new NotCapacityException("No hay más capacidad!");
        }

        for (int i=0; i < ticketDto.getCantidad(); i++){
            ticket = new Ticket();
            ticket.setUser(ticketDto.getUsuario());
            ticket.setIdFunction(ticketDto.getFuncionid());
            ticketList.add(defaultTicketRepository.createTicket(ticket));
        }
        return ticketList;
    }

    private boolean checkAvailability(Function function, int quantityToBuy) {
        int count = defaultTicketRepository.countTicketByFunction(function.getId());
        int maxCapacity = defaultTheaterService.findById(function.getIdTheater()).getCapacity();
        return (maxCapacity - count - quantityToBuy) >= 0 ? true : false;
    }
}