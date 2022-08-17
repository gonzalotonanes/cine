package com.cine.domain.ticket;

public interface TicketRepository {

    Ticket createTicket(Ticket ticket);
    int countTicketByFunction(int id);
}