package com.cine.domain.movie;

import java.util.Optional;

public interface MovieRepository {
    Optional<Movie> findByTitle(String title);
    Movie updateMovie(Movie movie);
}
