package com.cine.database.jparepositories;

import com.cine.database.entities.FunctionEntity;
import com.cine.domain.function.Function;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface FunctionJpaRepository extends JpaRepository<FunctionEntity, Integer> {

    List<FunctionEntity> findByIdMovie(int id);

    List<FunctionEntity> findByDateAndIdTheaterOrderByHourAsc(LocalDate date, int idTheater);

    List<FunctionEntity> findByDateOrIdMovieOrderByIdMovieAsc(LocalDate date, int titleId);

    @Query("SELECT COUNT(f) FROM FunctionEntity f WHERE f.idTheater=?1 ")
    int countAvailability(int idTheater);


    //posiblemente deba ser FunctionEntity
    List<FunctionEntity> findByDate(LocalDate date);
    List<FunctionEntity> findByDateAndIdMovie(LocalDate date, int idMovie);



}
