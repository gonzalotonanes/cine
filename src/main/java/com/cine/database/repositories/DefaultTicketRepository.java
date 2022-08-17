package com.cine.database.repositories;


import com.cine.database.entities.TicketEntity;
import com.cine.database.jparepositories.TicketJpaRepository;
import com.cine.domain.ticket.Ticket;
import com.cine.domain.ticket.TicketRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultTicketRepository implements TicketRepository {

    private TicketJpaRepository ticketJpaRepository;

    public DefaultTicketRepository(TicketJpaRepository ticketJpaRepository) {
        this.ticketJpaRepository = ticketJpaRepository;
    }

    @Override
    public Ticket createTicket(Ticket ticket){
        return toModel(ticketJpaRepository.save(toEntity(ticket)));
    }

    private TicketEntity toEntity(Ticket ticket){
        TicketEntity entity= new TicketEntity();
        entity.setUser(ticket.getUser());
        entity.setIdFunction(ticket.getIdFunction());
        return entity;
    }

    @Override
    public int countTicketByFunction(int id){
        return ticketJpaRepository.countAvailability(id);
    }

    private Ticket toModel(TicketEntity entity){
        Ticket ticket= new Ticket();
        ticket.setIdFunction(entity.getIdFunction());
        ticket.setId(entity.getIdTicket());
        ticket.setUser(entity.getUser());

        return ticket;
    }
}