package api;

import api.apiControllers.PeliculaApiController;
import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.dtos.PeliculaDto;
import api.entities.Genero;
import http.Client;
import http.HttpException;
import http.HttpRequest;
import http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PeliculaIT {

    @BeforeAll
    static void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }
    @Test
    void testCrearPelicula() {
        this.crear();
    }

    private String crear() {
        HttpRequest request = HttpRequest.builder(PeliculaApiController.PELICULAS).body(new PeliculaDto("1000","Avatar","Pelicula animacion 3D",2016, Genero.AVENTURA)).post();
        return (String) new Client().submit(request).getBody();
    }

    @Test
    void testPeliculaInvalidRequest() {
        HttpRequest request = HttpRequest.builder(PeliculaApiController.PELICULAS + "/invalid").body(null).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testCrearPeliculaSinPeliculaDto() {
        HttpRequest request = HttpRequest.builder(PeliculaApiController.PELICULAS).body(null).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testCrearPeliculasSinArgumentos() {
        HttpRequest request = HttpRequest.builder(PeliculaApiController.PELICULAS).body(null).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }
}
