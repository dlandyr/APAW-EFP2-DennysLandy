package api.dtos;

import api.entities.Pelicula;

public class PeliculaListaDto {

    private String id;
    private String titulo;

    public PeliculaListaDto(Pelicula pelicula){
        this.id=pelicula.getId();
        this.titulo=pelicula.getTitulo();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "PeliculaListaDto{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
