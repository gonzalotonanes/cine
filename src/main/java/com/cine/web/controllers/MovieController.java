package com.cine.web.controllers;

import com.cine.domain.movie.Movie;
import com.cine.domain.movie.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/pelicula")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") int id){
        return ResponseEntity.ok( movieService.findMovieById(id));
    }

    @GetMapping
    public ResponseEntity<?> getAllMovies(){
        return  ResponseEntity.ok(movieService.getAll());
    }
}
