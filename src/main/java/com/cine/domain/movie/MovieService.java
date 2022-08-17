package com.cine.domain.movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<Movie> getAll();
    Movie findMovieById(int id);

    Optional<Movie> findByTitle(String title);

    Movie updateMovie(Movie movie);
}