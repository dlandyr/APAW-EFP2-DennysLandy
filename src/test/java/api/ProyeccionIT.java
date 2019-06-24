package api;

import api.apiControllers.ProyeccionApiController;
import api.apiControllers.PeliculaApiController;
import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.entities.Sala;
import api.entities.Pelicula;
import api.dtos.ProyeccionDto;
import api.dtos.PeliculaDto;
import api.entities.Genero;
import http.Client;
import http.HttpException;
import http.HttpRequest;
import http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProyeccionIT {

    @BeforeAll
    static void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    @Test
    void testCrearProyeccion(){
        Sala sala= new Sala("001","sala01",45);
        Pelicula pelicula=new Pelicula("500","avatar","",2018,Genero.COMEDIA);
        LocalDateTime fecha= LocalDateTime.now();
        this.crear("500",fecha,"19h00,18h00,21h00",sala,pelicula);
    }
    private String crear(String id, LocalDateTime fecha, String hora, Sala sala, Pelicula pelicula){
        HttpRequest request = HttpRequest.builder(ProyeccionApiController.PROYECCIONES).body(new ProyeccionDto(id, fecha, hora, sala, pelicula)).post();
        return (String) new Client().submit(request).getBody();
    }

    @Test
    void testProyeccionesInvalidRequest() {
        HttpRequest request = HttpRequest.builder(ProyeccionApiController.PROYECCIONES + "/invalid").body(null).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testCrearProyeccionesSinArgumentos() {
        HttpRequest request = HttpRequest.builder(ProyeccionApiController.PROYECCIONES).body(null).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testModificarSalas() {
    }

    private String crearProyecion(String id, LocalDateTime fecha, String hora, Sala sala, Pelicula pelicula){
        HttpRequest request = HttpRequest.builder(ProyeccionApiController.PROYECCIONES).body(new ProyeccionDto(id, fecha, hora, sala, pelicula)).post();
        return (String) new Client().submit(request).getBody();
    }

    private String createPeliculas(String id, String titulo,String sinopsis, int anio, Genero genero){
        HttpRequest request = HttpRequest.builder(PeliculaApiController.PELICULAS).body(new PeliculaDto(id,titulo,sinopsis,anio,genero)).post();
        return (String) new Client().submit(request).getBody();
    }

    @Test
    void testUpdatePeliculas() {
        Sala sala= new Sala("100","sala05",50);
        Pelicula pelicula=new Pelicula("001","x-men","",2015,Genero.AVENTURA);
        LocalDateTime fecha= LocalDateTime.now();
        String id=this.crearProyecion("001",fecha,"14h00,16h00,17h50h00",sala,pelicula);

        List<String> peliculas = new ArrayList<String>();

        for (int i = 0; i <= 3; i++) {
            peliculas.add(createPeliculas("00" + i, "titulo0" + i, "", 2010, Genero.TERROR));
        }
        HttpRequest request = HttpRequest.builder(ProyeccionApiController.PROYECCIONES).path(ProyeccionApiController.ID_ID)
                .expandPath(id).path(ProyeccionApiController.PELICULAS).body(peliculas).patch();
        new Client().submit(request);
    }
}
