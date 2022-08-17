package com.cine.web.controllers;

import com.cine.domain.function.Function;
import com.cine.domain.function.FunctionService;
import com.cine.domain.movie.Movie;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;


@RestController
@RequestMapping("api/funcion")
@CrossOrigin
public class FunctionController {

    private FunctionService functionService;

    public FunctionController(FunctionService functionService) {
        this.functionService = functionService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> findByDateOrTitle(@RequestParam(value = "fecha" ,required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                           LocalDate fecha, @RequestParam(value = "pelicula" , required = false) String pelicula) {
        if (fecha==null)
            fecha= LocalDate.now();
        System.out.println("Fecha: "+ fecha);
        System.out.println("Pelicula: "+pelicula);
        return ResponseEntity.ok(functionService.findFunctions(fecha, pelicula));
    }

    @PostMapping()
    public ResponseEntity<?> registerNewFunction(@Valid @RequestBody RegisterFunctionDto dto) {
        return new ResponseEntity<Object>(functionService.createFunction(toModel(dto)), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") int id){
        return  ResponseEntity.ok(functionService.findById(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteFunction(@PathVariable(value = "id") int id){
        functionService.deleteFunction(id);
        return new ResponseEntity<>("Funcion eliminada", HttpStatus.ACCEPTED);
    }

    @GetMapping("/pelicula/{peliculaid}")
    public ResponseEntity<?> getFunctionsByIdMovie(@PathVariable(value = "peliculaid", required = true) int id){
            return ResponseEntity.ok(functionService.findFunctionByIdMovie(id));
    }





    @PutMapping("/pelicula/{id}")
    public ResponseEntity<?> updateMovie(@PathVariable(value = "id", required = true) int id,@Valid @RequestBody MovieDto dto){
        Movie movie= toModelMovie(dto,id);
        return ResponseEntity.ok(functionService.updateMovie(movie));
    }

    @GetMapping("/{id}/tickets")
    public ResponseEntity<?> ticketavailableFunction(@PathVariable("id") int id){
        return ResponseEntity.ok(functionService.checkAvailability(id));

    }


    private Function toModel(RegisterFunctionDto dto) {
        Movie movie= new Movie();
        movie.setId(dto.getIdMovie());
        Function function = new Function();
        function.setIdTheater(dto.getIdTheater());
        function.setIdMovie(dto.getIdMovie());
        function.setDate(dto.getDate());
        function.setHour(dto.getHour());
        return function;
    }

    private Movie toModelMovie(MovieDto dto, int id) {
        Movie movie= new Movie();

        movie.setId(id);
        movie.setSynopsis(dto.getSinopsis());
        movie.setPoster(dto.getPoster());
        movie.setTitle(dto.getTitulo());
        movie.setTrailer(dto.getTrailer());

        return movie;
    }

    @Data
    private  static class RegisterFunctionDto {

        @DecimalMin(value = "1", message = "Ingrese un número mayor o igual a 1")
        private int idMovie;

        @DecimalMin(value = "1", message = "Ingrese un número mayor o igual 1")
        private int idTheater;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        @NotNull(message = "Campo fecha no debe ser nulo")
        private LocalDate date;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
        @NotNull(message = "Campo hora no debe ser nulo")
        private LocalTime hour;
    }

    @Data
    private static class MovieDto{
        @NotBlank(message = "Título no puede estar vacío")
        private String titulo;
        @NotBlank(message = "poster no puede estar vacío")
        @NotEmpty()
        private String poster;
        @NotBlank(message = "Sinopsis no puede estar vacío")
        private String sinopsis;
        @NotBlank(message = "Trailer no puede estar vacío")
        private String trailer;
    }
}