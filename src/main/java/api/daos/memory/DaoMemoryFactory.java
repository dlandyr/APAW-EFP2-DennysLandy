package api.daos.memory;

import api.daos.DaoFactory;
import api.daos.PeliculaDao;
import api.daos.ProyeccionDao;
import api.daos.SalaDao;

public class DaoMemoryFactory extends DaoFactory {

    private SalaDao salaDao;
    private PeliculaDao peliculaDao;
    private ProyeccionDao proyeccionDao;

    @Override
    public SalaDao getSalaDao() {
        if (salaDao == null) {
            salaDao = new SalaDaoMemory();
        }
        return salaDao;
    }

    @Override
    public PeliculaDao getPeliculaDao() {
        if (peliculaDao == null) {
            peliculaDao = new PeliculaDaoMemory();
        }
        return peliculaDao;
    }

    @Override
    public ProyeccionDao getProyeccionDao() {
        if (proyeccionDao == null) {
            proyeccionDao = new ProyeccionDaoMemory();
        }
        return proyeccionDao;
    }
}
