package api.daos.memory;

import api.daos.SalaDao;
import api.entities.Sala;
import java.util.HashMap;

public class SalaDaoMemory extends GenericDaoMemory<Sala> implements SalaDao {

    public SalaDaoMemory(){
        super(new HashMap<>());
    }


    @Override
    public String getId(Sala sala) {
        return sala.getId();
    }

    @Override
    public void setId(Sala sala, String id) {
        sala.setId(id);
    }
}
