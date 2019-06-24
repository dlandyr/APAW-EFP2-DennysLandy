package api.businessController;

import api.daos.DaoFactory;
import api.dtos.ProyeccionDto;
import api.entities.Pelicula;
import api.entities.Proyeccion;
import api.entities.Sala;
import api.exceptions.NotFoundException;
import java.util.List;

public class ProyeccionBusinessController {

    public String crear(ProyeccionDto proyeccionDto){
        Proyeccion proyeccion = new Proyeccion(proyeccionDto.getId(),proyeccionDto.getFecha(),
                proyeccionDto.getHora(),proyeccionDto.getSala(),proyeccionDto.getPelicula());
        DaoFactory.getFactory().getProyeccionDao().save(proyeccion);
        return proyeccion.getId();
    }

    public void modificarSala(String proyeccionId, List<Sala> sala){
        Proyeccion proyeccion = DaoFactory.getFactory().getProyeccionDao().read(proyeccionId)
                .orElseThrow(()-> new NotFoundException("Proyeccion id: " + proyeccionId));
        proyeccion.setSalas(sala);
        DaoFactory.getFactory().getProyeccionDao().save(proyeccion);
    }

    public void modificarPeliculas(String proyeccionId, List<Pelicula> pelicula){
        Proyeccion proyeccion = DaoFactory.getFactory().getProyeccionDao().read(proyeccionId)
                .orElseThrow(()-> new NotFoundException("Proyeccion id: " + proyeccionId));
        proyeccion.setPeliculas(pelicula);
        DaoFactory.getFactory().getProyeccionDao().save(proyeccion);
    }
}
