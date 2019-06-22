package api.apiControllers;

import api.exceptions.ArgumentNotValidException;
import api.dtos.SalaDto;

import api.businessController.SalaBusinessController;

public class SalaApiController {

    public static final String SALAS = "/salas";

    private SalaBusinessController salaBusinessController = new SalaBusinessController();

    public String crear(SalaDto salaDto){
        this.validate(salaDto, "salaDto");
        this.validate(salaDto.getDescripcion(), "salaDto descripcion");
        return this.salaBusinessController.crear(salaDto);
    }

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is NULL");
        }
    }
}
