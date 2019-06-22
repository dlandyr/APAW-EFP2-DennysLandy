package api.businessController;

import api.daos.DaoFactory;
import api.dtos.SalaDto;
import api.entities.Sala;

public class SalaBusinessController {

    public String crear(SalaDto salaDto) {
        Sala sala = new Sala(salaDto.getId(),salaDto.getDescripcion(),salaDto.getNumeroAsientos());
        DaoFactory.getFactory().getSalaDao().save(sala);
        return sala.getId();
    }
}
