package api.apiControllers;

import api.dtos.SalaListaDto;
import api.exceptions.ArgumentNotValidException;
import api.dtos.SalaDto;
import api.businessController.SalaBusinessController;

import java.util.List;

public class SalaApiController {

    public static final String SALAS = "/salas";
    public static final String ID_ID = "/{id}";
    public static final String SEARCH = "/search";

    private SalaBusinessController salaBusinessController = new SalaBusinessController();

    public String crear(SalaDto salaDto){
        this.validate(salaDto, "salaDto");
        this.validate(salaDto.getDescripcion(), "salaDto descripcion");
        return this.salaBusinessController.crear(salaDto);
    }

    public void modificar(String id, SalaDto salaDto){
        this.validate(salaDto, "salaDto");
        this.validate(salaDto.getDescripcion(), "salaDto descripcion");
        this.salaBusinessController.modificarDescripcionSala(id, salaDto);
    }

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is NULL");
        }
    }

    public List<SalaListaDto> leerTodos(){
        return salaBusinessController.leer();
    }
}
