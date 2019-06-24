package api.dtos;

import api.entities.Genero;

public class PeliculaDto {

    private String id;
    private String titulo;
    private String sinopsis;
    private int anio;
    private Genero genero;

    public PeliculaDto(String id, String titulo){
        this.id=id;
        this.titulo=titulo;
        this.anio=anio;
        this.genero=genero;
    }

    public PeliculaDto(String id, String titulo, String sinopsis, int anio, Genero genero){
        this.id=id;
        this.titulo=titulo;
        this.sinopsis=sinopsis;
        this.anio=anio;
        this.genero=genero;
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

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "PeliculaDto{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", sinopsis='" + sinopsis + '\'' +
                ", anio=" + anio +
                ", genero=" + genero +
                '}';
    }
}
