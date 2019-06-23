package api.dtos;

public class SalaDto {

    private String id;
    private String descripcion;
    private int numeroAsientos;

    public SalaDto(String descripcion){
        this.descripcion=descripcion;
    }

    public SalaDto(String id, String descripcion){
        this.id=id;
        this.descripcion=descripcion;
    }

    public SalaDto(String id, String descripcion,int numeroAsientos){
        this.id=id;
        this.descripcion=descripcion;
        this.numeroAsientos=numeroAsientos;
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

    public int getNumeroAsientos() {
        return numeroAsientos;
    }

    public void setNumeroAsientos(int numeroAsientos) {
        this.numeroAsientos = numeroAsientos;
    }

    @Override
    public String toString() {
        return "SalaDto{" +
                "id='" + id + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", numeroAsientos=" + numeroAsientos +
                '}';
    }
}
