package api.businessController;

import api.daos.DaoFactory;
import api.dtos.PeliculaDto;
import api.entities.Pelicula;

public class PeliculaBusinessController {

    public String create(PeliculaDto peliculaDto){
        Pelicula pelicula = new Pelicula(peliculaDto.getId(),peliculaDto.getTitulo(),
                peliculaDto.getSinopsis(),peliculaDto.getAnio(),peliculaDto.getGenero());
        DaoFactory.getFactory().getPeliculaDao().save(pelicula);
        return pelicula.getId();
    }
}
