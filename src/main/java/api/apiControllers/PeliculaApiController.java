package api.apiControllers;

import api.businessController.PeliculaBusinessController;
import api.dtos.PeliculaDto;
import api.dtos.PeliculaListaDto;
import api.exceptions.ArgumentNotValidException;

import java.util.List;

public class PeliculaApiController {

    public static final String PELICULAS = "/peliculas";
    public static final String ID_ID = "/{id}";
    public static final String SEARCH = "/search";
    private PeliculaBusinessController peliculaBusinessController = new PeliculaBusinessController();

    public String crear(PeliculaDto peliculaDto) {
        this.validate(peliculaDto, "peliculaDto");
        this.validate(peliculaDto.getTitulo(), "peliculaDto Titulo");
        this.validate(peliculaDto.getAnio(), "peliculaDto Anio");
        this.validate(peliculaDto.getGenero(), "peliculaDto Genero");
        return this.peliculaBusinessController.crear(peliculaDto);
    }

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is NULL");
        }
    }

    public List<PeliculaListaDto> leerTodos(){
        return peliculaBusinessController.leer();
    }

    public void eliminar(String id) {
        this.peliculaBusinessController.eliminar(id);
    }

    public List<PeliculaListaDto> buscarPeliculasMayoresADeterminadoAnio(String anio){
        return peliculaBusinessController.buscarPorAnio(Integer.parseInt(anio));
    }
}
