package com.exFilmes.filmes.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmesDTO {

    private String tituloFilme, categoria;

    public FilmesDTO(String tituloFilme, String categoria) {
        this.tituloFilme = tituloFilme;
        this.categoria = categoria;
    }

    public String getTituloFilme() {
        return tituloFilme;
    }

    public void setTituloFilme(String tituloFilme) {
        this.tituloFilme = tituloFilme;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "FilmesDTO{" +
                "tituloFilme='" + tituloFilme + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
