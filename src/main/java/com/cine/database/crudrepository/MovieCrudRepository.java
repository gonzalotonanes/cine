package com.cine.database.crudrepository;

import com.cine.database.entities.MovieEntity;
import org.springframework.data.repository.CrudRepository;

public interface MovieCrudRepository extends CrudRepository<MovieEntity, Integer> {
}
