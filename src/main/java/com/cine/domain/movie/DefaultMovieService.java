package com.cine.domain.movie;

import com.cine.database.repositories.DefaultMovieRepository;
import com.cine.domain.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultMovieService implements  MovieService{

    private DefaultMovieRepository defaultMovieRepository;


    public DefaultMovieService(DefaultMovieRepository defaultMovieRepository) {
        this.defaultMovieRepository = defaultMovieRepository;
    }

    @Override
    public List<Movie> getAll() {
        return defaultMovieRepository.getAll();
    }

    @Override
    public Movie findMovieById(int id) {
        return defaultMovieRepository.findMovieById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Optional<Movie> findByTitle(String title) {
        return defaultMovieRepository.findByTitle(title);
    }

    @Override
    public Movie updateMovie(Movie movie) {
        movie= defaultMovieRepository.updateMovie(movie);

        return  movie;
    }
}
