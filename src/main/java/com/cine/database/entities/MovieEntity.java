package com.cine.database.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "peliculas")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "titulo", length = 50)
    private String title;

    @Column(name = "poster", length = 255)
    private String poster;

    @Column(name = "sinopsis", length = 255)
    private String synopsis;

    @Column(name = "trailer" , length = 255)
    private String trailer;

}