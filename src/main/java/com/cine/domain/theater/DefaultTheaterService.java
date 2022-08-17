package com.cine.domain.theater;

import com.cine.database.repositories.DefaultTheaterRepository;
import com.cine.domain.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultTheaterService implements TheaterService{

    private DefaultTheaterRepository defaultTheaterRepository;

    public DefaultTheaterService(DefaultTheaterRepository defaultTheaterRepository) {
        this.defaultTheaterRepository = defaultTheaterRepository;
    }

    @Override
    public Theater findById(int id) {
        return defaultTheaterRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<Theater> findAll() {
        return defaultTheaterRepository.findAll();
    }

}