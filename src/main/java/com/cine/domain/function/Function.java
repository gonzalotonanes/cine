package com.cine.domain.function;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class Function {

    private int id;
    private int idMovie;
    private int idTheater;
    private LocalDate date;
    private LocalTime hour;

}
