package com.cine.domain.function;

import com.cine.domain.movie.Movie;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface FunctionService {

    List<Function> findFunctionByIdMovie(int id);
    Function createFunction(Function function);
    Function findById(int id);
    List<Function> findByDateAndIdTheater(LocalDate date, int idTheater);
    List<Function> getAll();
    void deleteFunction(int id);
    List<Function> findByDateOrIdMovie(LocalDate date, String movie);
    int checkAvailability(int id);

    Movie updateMovie(Movie movie);

    List<Function> findFunctions(LocalDate date, String title);



}
