package api;

import api.apiControllers.SalaApiController;
import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.dtos.SalaDto;
import http.Client;
import http.HttpException;
import http.HttpRequest;
import http.HttpStatus;
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

}
