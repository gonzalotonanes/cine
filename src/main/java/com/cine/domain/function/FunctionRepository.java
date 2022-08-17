package com.cine.domain.function;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FunctionRepository {

    List<Function> findByDateOrIdMovie(LocalDate date, int idMovie);
    void deleteFunction(int id);
    Optional<Function> findById(int id);

    List<Function> findByDate(LocalDate date);

    List<Function> findByDateAndIdMovie(LocalDate date, int idMovie);
}
