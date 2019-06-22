package api.daos.memory;

import api.daos.DaoFactory;
import api.daos.SalaDao;

public class DaoMemoryFactory extends DaoFactory {

    private SalaDao salaDao;

    @Override
    public SalaDao getSalaDao() {
        if (salaDao == null) {
            salaDao = new SalaDaoMemory();
        }
        return salaDao;
    }
}
