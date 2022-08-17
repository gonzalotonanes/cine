package com.cine.domain.theater;
import java.util.List;

public interface TheaterService {

    Theater findById(int id);
    List<Theater> findAll();
}