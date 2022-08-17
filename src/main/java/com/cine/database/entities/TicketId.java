package com.cine.database.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class TicketId implements Serializable {

    private String idTicket;

    private int idFunction;

    public TicketId(String idTicket, int idFunction) {
        this.idTicket = idTicket;
        this.idFunction = idFunction;
    }

    public TicketId() {
    }
}
