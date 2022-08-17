package com.cine.database.crudrepository;

import com.cine.database.entities.TheaterEntity;
import org.springframework.data.repository.CrudRepository;

public interface TheaterCrudRepository extends CrudRepository<TheaterEntity, Integer> {
}
