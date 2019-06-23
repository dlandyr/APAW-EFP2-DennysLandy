package api.businessController;

import api.daos.DaoFactory;
import api.dtos.SalaDto;
import api.entities.Sala;
import api.exceptions.NotFoundException;

public class SalaBusinessController {

    public String crear(SalaDto salaDto) {
        Sala sala = new Sala(salaDto.getId(),salaDto.getDescripcion(),salaDto.getNumeroAsientos());
        DaoFactory.getFactory().getSalaDao().save(sala);
        return sala.getId();
    }

    public void modificarDescripcionSala(String id, SalaDto salaDto){
        Sala sala = DaoFactory.getFactory().getSalaDao().read(id).orElseThrow(() -> new NotFoundException("Sala id: " + id));
        sala.setDescripcion(salaDto.getDescripcion());
        DaoFactory.getFactory().getSalaDao().save(sala);
    }
}
