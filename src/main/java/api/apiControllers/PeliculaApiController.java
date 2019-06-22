package api.apiControllers;

import api.businessController.PeliculaBusinessController;
import api.dtos.PeliculaDto;
import api.exceptions.ArgumentNotValidException;

public class PeliculaApiController {

    public static final String PELICULAS = "/peliculas";
    private PeliculaBusinessController peliculaBusinessController = new PeliculaBusinessController();

    public String create(PeliculaDto peliculaDto) {
        this.validate(peliculaDto, "peliculaDto");
        this.validate(peliculaDto.getTitulo(), "peliculaDto Titulo");
        this.validate(peliculaDto.getAnio(), "peliculaDto Anio");
        this.validate(peliculaDto.getGenero(), "peliculaDto Genero");
        return this.peliculaBusinessController.create(peliculaDto);
    }

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is NULL");
        }
    }
}
