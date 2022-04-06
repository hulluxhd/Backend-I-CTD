package service.movie;

import java.util.Locale;

public class Movie {
    private String nome, country, link;

    public Movie(String nome, String pais, String link) {
        this.nome = nome;
        this.country = pais;
        this.link = link;
        ajustarLink();
    }

    public void ajustarLink(){
        this.setLink("www."+this.getNome().trim().toLowerCase(Locale.ROOT)+".com.br");
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "nome='" + nome + '\'' +
                ", country='" + country + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
