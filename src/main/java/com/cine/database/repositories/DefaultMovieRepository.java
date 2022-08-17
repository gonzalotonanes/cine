package com.cine.database.repositories;

import com.cine.database.entities.MovieEntity;
import com.cine.database.jparepositories.MovieJpaRepository;
import com.cine.domain.movie.Movie;
import com.cine.domain.movie.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class DefaultMovieRepository implements MovieRepository {

    @Autowired
    MovieJpaRepository movieJpaRepository;

    public List<Movie> getAll(){
        return movieJpaRepository.findAll().stream().map(this::toMovie).collect(Collectors.toList());
    }

    public Optional<Movie> findMovieById(int id){
        return movieJpaRepository.findById(id).map(this::toMovie);
    }

    private Movie toMovie(MovieEntity entity){
        Movie movie= new Movie();
        movie.setId(entity.getId());
        movie.setPoster(entity.getPoster());
        movie.setTitle(entity.getTitle());
        movie.setSynopsis(entity.getSynopsis());
        movie.setTrailer(entity.getTrailer());
        return  movie;
    }
    private MovieEntity toEntity(Movie movie){
        MovieEntity entity = new MovieEntity();
        entity.setId(movie.getId());
        entity.setPoster(movie.getPoster());
        entity.setSynopsis(movie.getSynopsis());
        entity.setTitle(movie.getTitle());
        entity.setTrailer(movie.getTrailer());

        return  entity;
    }

    @Override
    public Optional<Movie> findByTitle(String title) {
        return movieJpaRepository.findByTitle(title).map(this::toMovie);
    }

    @Override
    public Movie updateMovie(Movie movie) {
         movieJpaRepository.save(toEntity(movie));
         return  movie;
    }
}
