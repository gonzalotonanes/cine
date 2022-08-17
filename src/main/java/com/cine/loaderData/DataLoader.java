package com.cine.loaderData;

import com.cine.database.crudrepository.MovieCrudRepository;
import com.cine.database.crudrepository.TheaterCrudRepository;
import com.cine.database.entities.MovieEntity;
import com.cine.database.entities.TheaterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private MovieCrudRepository movieCrudRepository;
    @Autowired
    private TheaterCrudRepository theaterCrudRepository;

    @Override
    public void run(String... args) throws Exception {
        loadTheaterData();
        loadMovieData();
    }

    private void loadMovieData() {
        if (movieCrudRepository.count() == 0) {
            MovieEntity movie1= new MovieEntity();
            movie1.setTitle("Titanic");
            movie1.setPoster("https://movieposters2.com/images/782572-b.jpg");
            movie1.setSynopsis("Aunque la película no sigue al pie de la letra la historia original, sí que hubo un hombre y una mujer viviendo un amor prohibido a lomos del famoso Titanic, el Buque de los Sueños");
            movie1.setTrailer("https://www.youtube.com/embed/kVrqfYjkTdQ");

            MovieEntity movie2= new MovieEntity();
            movie2.setTitle("Hasta el último hombre");
            movie2.setPoster("https://www.lahiguera.net/cinemania/pelicula/7020/hasta_el_ultimo_hombre-cartel-7168.jpg");
            movie2.setSynopsis(", Hasta el último hombre es la más nueva. Dirigida por Mel Gibson y protagonizada por Andrew Garfield");
            movie2.setTrailer("https://www.youtube.com/embed/QJUsNs7tLFA");

            MovieEntity movie3= new MovieEntity();
            movie3.setTitle("El lobo de Wall Street");
            movie3.setPoster("https://m.media-amazon.com/images/I/51U1oq-mf8L._AC_.jpg");
            movie3.setSynopsis("El lobo de Wall Street es una película basada en hechos reales. Jamás lo hubiese dicho");
            movie3.setTrailer("https://www.youtube.com/embed/DO_96Ee_qWw");

            MovieEntity movie4= new MovieEntity();
            movie4.setTitle("El mayordomo");
            movie4.setPoster("https://i0.wp.com/www.bitacine.com/wp-content/uploads/2013/10/el-mayordomo-poster.jpg?fit=1120%2C1600&ssl=1");
            movie4.setSynopsis("El mayordomo cuenta la historia de Eugene Allen, un mayordomo afroamericano que estuvo al servicio de la Casa Blanca durante 34 años.");
            movie4.setTrailer("https://www.youtube.com/embed/las7FZam7pI");

            MovieEntity movie5= new MovieEntity();
            movie5.setTitle("El exorcista");
            movie5.setPoster("https://www.ecartelera.com/carteles/5100/5147/001_m.jpg");
            movie5.setSynopsis("Esta es una de esas historias que alguien nos cuenta y no le damos crédito y es que, cuando del demonio o de espíritus se tratar, nos cuesta creer en ello.");
            movie5.setTrailer("https://www.youtube.com/embed/7iCJssW8XiI");

            MovieEntity movie6= new MovieEntity();
            movie6.setTitle("Lo imposible");
            movie6.setPoster("https://i.pinimg.com/originals/b4/6d/9b/b46d9bf38ef2c98247aa61d8cc4f170e.jpg");
            movie6.setSynopsis("Juan Antonio Bayona habría estado más acertado si, en lugar de Lo imposible, hubiese llamado a esta película ‘El milagro’. ");
            movie6.setTrailer("https://www.youtube.com/embed/JHldZNvZY4Q");

            MovieEntity movie7= new MovieEntity();
            movie7.setTitle("La voz dormida");
            movie7.setPoster("https://es.web.img3.acsta.net/medias/nmedia/18/84/64/84/19807035.jpg");
            movie7.setSynopsis("Siempre tengo problemas para decantarme por La voz dormida o Las 13 rosas. Ambas tocan el tema de la Guerra Civil, desde el mismo bando y en la piel de mujeres");
            movie7.setTrailer("https://www.youtube.com/embed/jBCrSolMDyw");

            MovieEntity movie8= new MovieEntity();
            movie8.setTitle("¡Viven!");
            movie8.setPoster("https://es.web.img2.acsta.net/medias/nmedia/18/95/86/87/20432150.jpg");
            movie8.setSynopsis("Hace algunos días pude ver una entrevista que Risto Mejide hacía al más joven de los supervivientes de esta tremenda historia, Carlitos Páez. ¡Viven! narra lo vivido por un equipo de fútbol");
            movie8.setTrailer("https://www.youtube.com/embed/QrQtVWzZC_U");

            MovieEntity movie9= new MovieEntity();
            movie9.setTitle("El Pianista");
            movie9.setPoster("https://es.web.img2.acsta.net/pictures/14/05/27/12/07/438875.jpg");
            movie9.setSynopsis("El Pianista es una película desgarradora, delicada y bella a partes iguales que nos cuenta el drama de la persecución a los judíos");
            movie9.setTrailer("https://www.youtube.com/embed/yDA1mK6v-ME");

            MovieEntity movie10= new MovieEntity();
            movie10.setTitle("Siempre a tu lado (Hachiko)");
            movie10.setPoster("https://pics.filmaffinity.com/Siempre_a_tu_lado-386676685-large.jpg");
            movie10.setSynopsis("Una película muy tierna con Hachiko como protagonista. Un perro que esperó con paciencia el regreso de su dueño durante años");
            movie10.setTrailer("https://www.youtube.com/embed/jrVVIaO_hTg");

            movieCrudRepository.save(movie1);
            movieCrudRepository.save(movie2);
            movieCrudRepository.save(movie3);
            movieCrudRepository.save(movie4);
            movieCrudRepository.save(movie5);
            movieCrudRepository.save(movie6);
            movieCrudRepository.save(movie7);
            movieCrudRepository.save(movie8);
            movieCrudRepository.save(movie9);
            movieCrudRepository.save(movie10);

        }
    }

    private void loadTheaterData() {
        if (theaterCrudRepository.count() == 0) {
            TheaterEntity entity1 = new TheaterEntity();
            entity1.setCapacity(5);
            TheaterEntity entity2 = new TheaterEntity();
            entity2.setCapacity(15);
            TheaterEntity entity3 = new TheaterEntity();
            entity3.setCapacity(35);

            theaterCrudRepository.save(entity1);
            theaterCrudRepository.save(entity2);
            theaterCrudRepository.save(entity3);

        }

    }

}
