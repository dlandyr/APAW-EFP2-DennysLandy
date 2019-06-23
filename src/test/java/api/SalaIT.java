package api;

import api.apiControllers.SalaApiController;
import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.dtos.SalaDto;
import http.Client;
import http.HttpException;
import http.HttpRequest;
import http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class SalaIT {

    @BeforeAll
    static void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }
    @Test
    void testCrearSala() {
        this.crear();
    }

    private String crear() {
        HttpRequest request = HttpRequest.builder(SalaApiController.SALAS).body(new SalaDto("001","sala01",45)).post();
        return (String) new Client().submit(request).getBody();
    }

    @Test
    void testSalaInvalidRequest() {
        HttpRequest request = HttpRequest.builder(SalaApiController.SALAS + "/invalid").body(null).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testCrearSalaSinSalaDto() {
        HttpRequest request = HttpRequest.builder(SalaApiController.SALAS).body(null).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testCrearSalaSinSalaDtoDescripcion() {
        HttpRequest request = HttpRequest.builder(SalaApiController.SALAS).body(new SalaDto(null,null)).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testModificarSala(){
        String id = this.crear();
        LogManager.getLogger().info("sala: "+ id);
        HttpRequest request = HttpRequest.builder(SalaApiController.SALAS).path(SalaApiController.ID_ID)
                .expandPath(id).body(new SalaDto("sala10_3D")).put();
        new Client().submit(request);
    }

    @Test
    void testModificarSalaSinSalaDto() {
        String id = this.crear();
        HttpRequest request = HttpRequest.builder(SalaApiController.SALAS).path(SalaApiController.ID_ID)
                .expandPath(id).body(null).put();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }
    @Test
    void testModificarSalaSinDescripcion() {
        HttpRequest request = HttpRequest.builder(SalaApiController.SALAS).path(SalaApiController.ID_ID)
                .expandPath("invalid-id").body(new SalaDto(null)).put();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

}
