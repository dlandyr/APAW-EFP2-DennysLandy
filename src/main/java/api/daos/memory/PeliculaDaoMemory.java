package api.daos.memory;

import api.daos.PeliculaDao;
import api.entities.Pelicula;
import java.util.HashMap;

public class PeliculaDaoMemory extends GenericDaoMemory<Pelicula> implements PeliculaDao {

    public PeliculaDaoMemory() {
        super(new HashMap<>());
    }

    @Override
    public String getId(Pelicula pelicula) {
        return pelicula.getId();
    }

    @Override
    public void setId(Pelicula pelicula, String id) {
        pelicula.setId(id);

    }
}
