package com.cine.database.repositories;

import com.cine.database.entities.FunctionEntity;
import com.cine.database.entities.MovieEntity;
import com.cine.database.jparepositories.FunctionJpaRepository;
import com.cine.domain.function.Function;
import com.cine.domain.function.FunctionRepository;
import com.cine.domain.movie.Movie;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class DefaultFunctionRepository implements FunctionRepository {

    FunctionJpaRepository functionJpaRepository;

    public DefaultFunctionRepository(FunctionJpaRepository functionJpaRepository) {
        this.functionJpaRepository = functionJpaRepository;
    }

    public List<Function> findFunctionByIdMovie(int id){
        return functionJpaRepository.findByIdMovie(id).stream().map(this::toFunction).collect(Collectors.toList());
    }

    public Function save(Function function){
        return toFunction(functionJpaRepository.save(toEntity(function)));
    }


    public Optional<Function> findById(int id){
        return functionJpaRepository.findById(id).map(this::toFunction);
    }

    @Override
    public List<Function> findByDate(LocalDate date) {
        return functionJpaRepository.findByDate(date).stream().map(this::toFunction).collect(Collectors.toList());
    }

    @Override
    public List<Function> findByDateAndIdMovie(LocalDate date, int idMovie) {
        return functionJpaRepository.findByDateAndIdMovie(date, idMovie).stream().map(this::toFunction).collect(Collectors.toList());
    }

    public List<Function> getAll(){
        return  functionJpaRepository.findAll().stream().map(this::toFunction).collect(Collectors.toList());
    }

    public List<Function> findByDateAndIdTheater(LocalDate date, int idTheater){

        return  functionJpaRepository.findByDateAndIdTheaterOrderByHourAsc(date,idTheater).stream().map(this::toFunction).collect(Collectors.toList());
    }

    private FunctionEntity toEntity(Function function){
        FunctionEntity entity= new FunctionEntity();
        entity.setDate(function.getDate());
        entity.setIdMovie(function.getIdMovie());
        entity.setIdTheater(function.getIdTheater());
        entity.setHour(function.getHour());
        return  entity;
    }

    private Function toFunction(FunctionEntity entity){
        Function function= new Function();
        function.setId(entity.getId());
        function.setDate(entity.getDate());
        function.setHour(entity.getHour());
        function.setIdTheater(entity.getIdTheater());
        function.setIdMovie(entity.getIdMovie());
        return  function;
    }

    private MovieEntity movieToEntity(Movie movie){
        MovieEntity entity = new MovieEntity();
        entity.setTrailer(movie.getTrailer());
        entity.setTitle(movie.getTitle());
        entity.setPoster(movie.getPoster());
        entity.setSynopsis(movie.getSynopsis());
        entity.setId(movie.getId());
        return  entity;
    }

    private Movie movieEntityToModel(MovieEntity entity){
        Movie model = new Movie();
        model.setTrailer(entity.getTrailer());
        model.setTitle(entity.getTitle());
        model.setPoster(entity.getPoster());
        model.setSynopsis(entity.getSynopsis());
        model.setId(entity.getId());
        return  model;
    }

    @Override
    public List<Function> findByDateOrIdMovie(LocalDate date, int idMovie) {
        return functionJpaRepository.findByDateOrIdMovieOrderByIdMovieAsc(date, idMovie).stream().map(this::toFunction).collect(Collectors.toList());
    }

    @Override
    public void deleteFunction(int id) {
        functionJpaRepository.deleteById(id);
    }
}