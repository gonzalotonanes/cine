package com.cine.database.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="tickets")
@IdClass(TicketId.class)
public class TicketEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ticketId")
    private String idTicket;


    @Id
    @JoinColumn(name = "funcionId", referencedColumnName = "id")
    private int idFunction;

    @Column(name = "usuario", length = 50)
    private String user;
}