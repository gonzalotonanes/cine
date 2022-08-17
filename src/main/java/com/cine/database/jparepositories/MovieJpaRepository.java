package com.cine.database.jparepositories;

import com.cine.database.entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieJpaRepository extends JpaRepository<MovieEntity, Integer> {

    Optional<MovieEntity> findByTitle(String title);
}
