package api.apiControllers;

import api.businessController.ProyeccionBusinessController;
import api.dtos.ProyeccionDto;
import api.exceptions.ArgumentNotValidException;

public class ProyeccionApiController {

    public static final String PROYECCION = "/proyecciones";

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
}
