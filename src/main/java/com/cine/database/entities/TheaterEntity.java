package com.cine.database.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="salas")
public class TheaterEntity {

    @Id
    @Column(name = "salaId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="capacidad")
    private int capacity;

}