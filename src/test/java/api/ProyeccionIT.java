package api;

import api.apiControllers.ProyeccionApiController;
import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.entities.Sala;
import api.entities.Pelicula;
import api.dtos.ProyeccionDto;
import api.entities.Genero;
import http.Client;
import http.HttpException;
import http.HttpRequest;
import http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

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

}
