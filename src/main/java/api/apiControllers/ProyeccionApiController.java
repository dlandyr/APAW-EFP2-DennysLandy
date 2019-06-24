package api.apiControllers;

import api.businessController.ProyeccionBusinessController;
import api.dtos.ProyeccionDto;
import api.entities.Pelicula;
import api.entities.Sala;
import api.exceptions.ArgumentNotValidException;

import java.util.List;

public class ProyeccionApiController {

    public static final String PROYECCIONES = "/proyecciones";
    public static final String ID_ID = "/{id}";
    public static final String SALAS = "/salas";
    public static final String PELICULAS = "/peliculas";

    private ProyeccionBusinessController proyeccionBusinessController = new ProyeccionBusinessController();

    public String crear(ProyeccionDto proyeccionDto){
        this.validate(proyeccionDto, "proyeccionDto");
        this.validate(proyeccionDto.getFecha(), "proyeccionDto fecha");
        this.validate(proyeccionDto.getSala(), "proyeccionDto sala");
        this.validate(proyeccionDto.getPelicula(), "proyeccionDto pelicula");
        return this.proyeccionBusinessController.crear(proyeccionDto);
    }

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is NULL");
        }
    }

    public void modificarSala(String proyeccionId, List<Sala> sala) {
        this.validate(sala, "sala");
        this.proyeccionBusinessController.modificarSala(proyeccionId, sala);
    }

    public void modificarPeliculas(String proyeccionId, List<Pelicula> pelicula) {
        this.validate(pelicula, "pelicula");
        this.proyeccionBusinessController.modificarPeliculas(proyeccionId, pelicula);
    }
}
