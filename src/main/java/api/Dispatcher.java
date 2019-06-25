package api;

import api.apiControllers.SalaApiController;
import api.apiControllers.PeliculaApiController;
import api.apiControllers.ProyeccionApiController;
import api.dtos.ProyeccionDto;
import api.dtos.SalaDto;
import api.dtos.PeliculaDto;
import api.entities.Pelicula;
import api.entities.Proyeccion;
import api.entities.Sala;
import api.exceptions.ArgumentNotValidException;
import api.exceptions.NotFoundException;
import api.exceptions.RequestInvalidException;
import http.HttpRequest;
import http.HttpResponse;
import http.HttpStatus;

import java.util.List;

public class Dispatcher {

    private SalaApiController salaApiController = new SalaApiController();
    private PeliculaApiController peliculaApiController = new PeliculaApiController();
    private ProyeccionApiController proyeccionApiController = new ProyeccionApiController();

    public void submit(HttpRequest request, HttpResponse response) {
        String ERROR_MESSAGE = "{'error':'%S'}";
        try {
            switch (request.getMethod()) {
                case POST:
                    this.doPost(request, response);
                    break;
                case PUT:
                    this.doPut(request, response);
                    break;
                case GET:
                    this.doGet(request, response);
                    break;
                case PATCH:
                    this.doPatch(request);
                    break;
                case DELETE:
                    this.doDelete(request, response);
                    break;
                default:
                    throw new RequestInvalidException("method error: " + request.getMethod());
            }        } catch (ArgumentNotValidException | RequestInvalidException exception) {
            response.setBody(String.format(ERROR_MESSAGE, exception.getMessage()));
            response.setStatus(HttpStatus.BAD_REQUEST);
        }catch (NotFoundException exception) {
            response.setBody(String.format(ERROR_MESSAGE, exception.getMessage()));
            response.setStatus(HttpStatus.NOT_FOUND);
        }catch (Exception exception) {
            exception.printStackTrace();
            response.setBody(String.format(ERROR_MESSAGE, exception));
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void doPost(HttpRequest request, HttpResponse response) {
        if (request.isEqualsPath(SalaApiController.SALAS)) {
            response.setBody(this.salaApiController.crear((SalaDto) request.getBody()));
        } else if (request.isEqualsPath(PeliculaApiController.PELICULAS)) {
            response.setBody(this.peliculaApiController.crear((PeliculaDto) request.getBody()));
        } else if (request.isEqualsPath(ProyeccionApiController.PROYECCIONES)) {
            response.setBody(this.proyeccionApiController.crear((ProyeccionDto) request.getBody()));
        } else if (request.isEqualsPath(ProyeccionApiController.PROYECCIONES + ProyeccionApiController.ID_ID + ProyeccionApiController.PELICULAS)) {
            this.proyeccionApiController.modificarPeliculas(request.getPath(1), (List<Pelicula>) request.getBody());
        } else {
            throw new RequestInvalidException("method error: " + request.getMethod());
        }
    }

    private void doPut(HttpRequest request, HttpResponse response) {
        if (request.isEqualsPath(SalaApiController.SALAS + SalaApiController.ID_ID)) {
            this.salaApiController.modificar(request.getPath(1), (SalaDto) request.getBody());
        } else {
            throw new RequestInvalidException("method error: " + request.getMethod() + ' ' + request.getPath());
        }
    }

    private void doGet(HttpRequest request, HttpResponse response) {
        if (request.isEqualsPath(PeliculaApiController.PELICULAS)){
            response.setBody(this.peliculaApiController.leerTodos());
        } else if (request.isEqualsPath(SalaApiController.SALAS)){
            response.setBody(this.salaApiController.leerTodos());
        }else if (request.isEqualsPath(PeliculaApiController.PELICULAS  + PeliculaApiController.SEARCH)) {
            response.setBody(this.peliculaApiController.buscarPeliculasMayoresADeterminadoAnio(request.getParams().get("anio")));
        } else{
            throw new RequestInvalidException("method error: " + request.getMethod() + ' ' + request.getPath());

        }
    }

    private void doPatch(HttpRequest request) {
        if (request.isEqualsPath(ProyeccionApiController.PROYECCIONES + ProyeccionApiController.ID_ID + ProyeccionApiController.SALAS)) {
            this.proyeccionApiController.modificarSala(request.getPath(1), (List<Sala>) request.getBody());
        }
    }

    private void doDelete(HttpRequest request, HttpResponse response) {
        if (request.isEqualsPath(PeliculaApiController.PELICULAS + PeliculaApiController.ID_ID)){
            this.peliculaApiController.eliminar(request.getPath(1));
        }
    }
}
