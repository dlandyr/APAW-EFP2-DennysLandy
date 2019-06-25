package api.businessController;

import api.daos.DaoFactory;
import api.dtos.SalaDto;
import api.dtos.SalaListaDto;
import api.entities.Sala;
import java.util.List;
import java.util.ArrayList;
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

    public List<SalaListaDto> leer(){
        List<Sala> salalist = DaoFactory.getFactory().getSalaDao().findAll();
        List<SalaListaDto> salaaListaDtos = new ArrayList<>();
        for (Sala sala : salalist){
            salaaListaDtos.add(new SalaListaDto(sala));
        }
        return salaaListaDtos;
    }

    public void eliminar(String id){
        DaoFactory.getFactory().getSalaDao().deleteById(id);
    }


}
