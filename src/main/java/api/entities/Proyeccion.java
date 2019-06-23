package api.entities;

import java.time.LocalDateTime;
import java.util.List;

public class Proyeccion {

    private String id;
    private LocalDateTime fecha;
    private String hora;
    private Sala sala;
    private Pelicula pelicula;
    private List<Sala> salas;

    public Proyeccion(String id, Sala sala, Pelicula pelicula){
        this.id=id;
        this.sala=sala;
        this.pelicula=pelicula;
    }
    public Proyeccion(String id, LocalDateTime fecha, String hora, Sala sala, Pelicula pelicula){
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

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    @Override
    public String toString() {
        return "Proyeccion{" +
                "id='" + id + '\'' +
                ", fecha=" + fecha +
                ", hora='" + hora + '\'' +
                ", sala=" + sala +
                ", pelicula=" + pelicula +
                '}';
    }
}
