package api.businessController;

import api.daos.DaoFactory;
import api.dtos.PeliculaDto;
import api.dtos.PeliculaListaDto;
import api.entities.Pelicula;
import java.util.List;
import java.util.ArrayList;

public class PeliculaBusinessController {

    public String crear(PeliculaDto peliculaDto){
        Pelicula pelicula = new Pelicula(peliculaDto.getId(),peliculaDto.getTitulo(),
                peliculaDto.getSinopsis(),peliculaDto.getAnio(),peliculaDto.getGenero());
        DaoFactory.getFactory().getPeliculaDao().save(pelicula);
        return pelicula.getId();
    }

    public List<PeliculaListaDto> leer(){
        List<Pelicula> peliculalist = DaoFactory.getFactory().getPeliculaDao().findAll();
        List<PeliculaListaDto> peliculaListaDtos = new ArrayList<>();
        for (Pelicula pelicula : peliculalist){
            peliculaListaDtos.add(new PeliculaListaDto(pelicula));
        }
        return peliculaListaDtos;
    }

    public void eliminar(String id){
        DaoFactory.getFactory().getPeliculaDao().deleteById(id);
    }

    public List<PeliculaListaDto> buscarPorAnio(int anio){
        List<Pelicula> peliculaList = DaoFactory.getFactory().getPeliculaDao().findAll();
        List<PeliculaListaDto>  peliculaListaDtos = new ArrayList<>();
        for (Pelicula pelicula : peliculaList){
            if (pelicula.getAnio()>=anio)
                peliculaListaDtos.add(new PeliculaListaDto(pelicula));
        }
        return peliculaListaDtos;
    }
}
