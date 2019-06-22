package api.entities;

public class Promocion {

    private String id;
    private String descripcion;
    private Boolean estado;

    public Promocion(String id, String descripcion, Boolean estado){
        this.id=id;
        this.descripcion=descripcion;
        this.estado=estado;
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Promocion{" +
                "id='" + id + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                '}';
    }
}
