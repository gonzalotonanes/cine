package com.cine.database.jparepositories;

import com.cine.database.entities.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterJpaRepository extends JpaRepository<TheaterEntity, Integer> {
}
