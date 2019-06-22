package api.businessController;

import api.daos.DaoFactory;
import api.dtos.SalaDto;
import api.entities.Sala;

public class SalaBusinessController {

    public String create(SalaDto salaDto) {
        Sala sala = new Sala(salaDto.getId(),salaDto.getDescripcion(),0);
        DaoFactory.getFactory().getSalaDao().save(sala);
        return sala.getId();
    }
}
