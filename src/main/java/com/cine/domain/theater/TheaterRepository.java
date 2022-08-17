package com.cine.domain.theater;

import java.util.List;
import java.util.Optional;

public interface TheaterRepository {

    List<Theater> findAll();
    Optional<Theater> findById(int id);
}
