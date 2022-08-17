package com.cine.domain.function;

import com.cine.database.repositories.DefaultFunctionRepository;
import com.cine.database.repositories.DefaultTheaterRepository;
import com.cine.database.repositories.DefaultTicketRepository;
import com.cine.domain.exceptions.DomainException;
import com.cine.domain.exceptions.NotFoundException;
import com.cine.domain.movie.DefaultMovieService;
import com.cine.domain.movie.Movie;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.time.temporal.ChronoUnit.MINUTES;

@Service
public class DefaultFunctionService implements FunctionService {

    private DefaultFunctionRepository defaultFunctionRepository;
    private DefaultTicketRepository defaultTicketRepository;
    private DefaultMovieService movieService;
    private DefaultTheaterRepository defaultTheaterRepository;


    public DefaultFunctionService(DefaultFunctionRepository defaultFunctionRepository, DefaultMovieService defaultMovieService, DefaultTicketRepository defaultTicketRepository
            , DefaultTheaterRepository defaultTheaterRepository) {
        this.defaultFunctionRepository = defaultFunctionRepository;
        this.movieService = defaultMovieService;
        this.defaultTicketRepository = defaultTicketRepository;
        this.defaultTheaterRepository = defaultTheaterRepository;

    }

    @Override
    public List<Function> findFunctionByIdMovie(int id) {

        List<Function> functions = defaultFunctionRepository.findFunctionByIdMovie(id);
        if (functions.size() == 0)
            throw new NotFoundException("No hay peliculas con la funcion: " + id);

        return functions;
    }

    @Override
    public Function createFunction(Function function) {

        movieService.findMovieById(function.getIdMovie());
        defaultTheaterRepository.findById(function.getIdTheater()).orElseThrow(NotFoundException::new);

        boolean checkFunction = this.checkFunction(function.getDate(), function.getIdTheater(), function.getHour());

        if (!checkFunction) {
            throw new DomainException("Deben elegir otro horario");
        }
        return defaultFunctionRepository.save(function);
    }

    @Override
    public Function findById(int id) {
        System.out.println("ACA");
        Function f = defaultFunctionRepository.findById(id).orElseThrow(NotFoundException::new);
        System.out.println(f.getDate());
        return  f;
    }

    @Override
    public List<Function> findByDateAndIdTheater(LocalDate date, int idTheater) {
        return defaultFunctionRepository.findByDateAndIdTheater(date, idTheater);
    }

    @Override
    public List<Function> getAll() {
        return defaultFunctionRepository.getAll();
    }

    @Override
    public void deleteFunction(int id) {
        defaultFunctionRepository.deleteFunction(id);
    }

    //POSIBLEMENTE BORRAR ESTE
    @Override
    public List<Function> findByDateOrIdMovie(LocalDate date, String title) {

        int idMovie = -1;
        //Movie movie = movieService.findByTitle(title).orElseThrow(NotFoundException::new);
        if (title != null) {
            Movie movie = movieService.findByTitle(title).get();
            idMovie = movie.getId();
        }


        //return defaultFunctionRepository.findByDateOrIdMovie(date,Movie.getId());
        return defaultFunctionRepository.findByDateOrIdMovie(date, idMovie);
    }

    //NUEVO MÉTODO PARA ENCONTRAR POR FUNCIONES POR FECHA O POR PELÍCULA

    @Override
    public List<Function> findFunctions(LocalDate date, String title) {

        Optional<Movie> movie = movieService.findByTitle(title);
        List<Function> functions = null;

        if (title == null)
            functions = defaultFunctionRepository.findByDate(date);

        else {

            if (movie.isEmpty()) {
                throw new NotFoundException("Pelicula no existente");
            }
            functions = defaultFunctionRepository.findByDateAndIdMovie(date, movie.get().getId());
        }

        return functions;
    }


    @Override
    public int checkAvailability(int id) {
        Function function = defaultFunctionRepository.findById(id).orElseThrow(DomainException::new);

        int countTickets = defaultTicketRepository.countTicketByFunction(function.getId());
        int maxCapacity = defaultTheaterRepository.findById(function.getIdTheater()).get().getCapacity();

        if ((maxCapacity - countTickets) > 0) {
            return maxCapacity - countTickets;
        } else {
            return 0;
        }
    }


    @Override
    public Movie updateMovie(Movie movie) {
        Movie updateMovie = new Movie();
        updateMovie.setId(movie.getId());
        updateMovie.setTitle(movie.getTitle());
        updateMovie.setTrailer(movie.getTrailer());
        updateMovie.setPoster(movie.getPoster());
        updateMovie.setSynopsis(movie.getSynopsis());

        return movieService.updateMovie(updateMovie);
    }


    private boolean checkFunction(LocalDate date, int idTheater, LocalTime hour) {
        List<Function> functions = defaultFunctionRepository.findByDateAndIdTheater(date, idTheater);
        for (Function f : functions) {
            LocalTime time = f.getHour();
            int dif = (int) MINUTES.between(time, hour);

            if (dif <= 150 && dif >= -150) {
                return false;
            }
        }
        return true;
    }
}