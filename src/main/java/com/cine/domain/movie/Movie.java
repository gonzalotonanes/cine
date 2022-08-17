package com.cine.domain.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    private int id;
    private String title;
    private String poster;
    private String Synopsis;
    private String trailer;

    public Movie(String title, String poster, String synopsis, String trailer) {
        this.title = title;
        this.poster = poster;
        this.Synopsis = synopsis;
        this.trailer = trailer;
    }
}
