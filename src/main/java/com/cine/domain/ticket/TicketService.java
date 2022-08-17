package com.cine.domain.ticket;

import java.util.List;

public interface TicketService {

    List<Ticket> createTicket(RequestTicketDto ticket);
    int countTicketByFunction(int id);
}