package api.dtos;

import api.entities.Pelicula;
import api.entities.Sala;

import java.time.LocalDateTime;

public class ProyeccionDto {

    private String id;
    private LocalDateTime fecha;
    private String hora;
    private Sala sala;
    private Pelicula pelicula;

    public ProyeccionDto(String id, Sala sala, Pelicula pelicula){
        this.id=id;
        this.sala=sala;
        this.pelicula=pelicula;
    }
    public ProyeccionDto(String id, LocalDateTime fecha, String hora, Sala sala, Pelicula pelicula){
        this.id=id;
        this.fecha=fecha;
        this.hora=hora;
        this.sala=sala;
        this.pelicula=pelicula;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    @Override
    public String toString() {
        return "ProyeccionDto{" +
                "id='" + id + '\'' +
                ", fecha=" + fecha +
                ", hora='" + hora + '\'' +
                ", sala=" + sala +
                ", pelicula=" + pelicula +
                '}';
    }
}
