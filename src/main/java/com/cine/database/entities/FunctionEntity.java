package com.cine.database.entities;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "funciones")
public class FunctionEntity {

    @Id
    @Column(name ="funcionId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "fecha")
    private LocalDate date;

    @Column(name= "hora")
    private LocalTime hour;

    @Column(name = "PeliculaId")
    @JoinColumn(name = "PeliculaId", referencedColumnName = "id")
    private int idMovie;

    @Column(name = "SalaId")
    @JoinColumn(name = "SalaId", referencedColumnName = "id")
    private int idTheater;
}