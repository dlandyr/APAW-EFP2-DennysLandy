package api.daos.memory;

import api.daos.ProyeccionDao;
import api.entities.Proyeccion;

import java.util.HashMap;

public class ProyeccionDaoMemory extends GenericDaoMemory<Proyeccion> implements ProyeccionDao {

    public ProyeccionDaoMemory() {
        super(new HashMap<>());
    }

    @Override
    public String getId(Proyeccion proyeccion) {
        return proyeccion.getId();
    }

    @Override
    public void setId(Proyeccion proyeccion, String id) {
        proyeccion.setId(id);

    }
}
