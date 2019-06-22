package api.businessController;

import api.daos.DaoFactory;
import api.dtos.ProyeccionDto;
import api.entities.Proyeccion;

public class ProyeccionBusinessController {

    public String crear(ProyeccionDto proyeccionDto){
        Proyeccion proyeccion = new Proyeccion(proyeccionDto.getId(),proyeccionDto.getFecha(),
                proyeccionDto.getHora(),proyeccionDto.getSala(),proyeccionDto.getPelicula());
        DaoFactory.getFactory().getProyeccionDao().save(proyeccion);
        return proyeccion.getId();
    }
}
