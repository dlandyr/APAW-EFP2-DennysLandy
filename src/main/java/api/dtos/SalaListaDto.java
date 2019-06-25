package api.dtos;
import api.entities.Sala;

public class SalaListaDto {

    private String id;
    private String descripcion;
    private int numeroAsiento;

    public SalaListaDto(Sala sala){
        this.id=sala.getId();
        this.descripcion=sala.getDescripcion();
        this.numeroAsiento=sala.getNumeroAsientos();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    @Override
    public String toString() {
        return "SalaListaDto{" +
                "id='" + id + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", numeroAsiento=" + numeroAsiento +
                '}';
    }
}
