package model;

import java.io.Serializable;

public class Favorito implements Serializable {

    private String url, nome;

    public Favorito(String url, String nome) {
        this.url = url;
        this.nome = nome;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
