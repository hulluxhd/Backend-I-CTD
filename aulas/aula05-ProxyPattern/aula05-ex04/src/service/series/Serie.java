package service.series;

import java.util.Locale;

public class Serie {
    private String nome;
    private String link;
    private int qtdViews = 0;
    public Serie(String nome) {
        this.nome = nome;
        this.link = "www."+this.getNome().trim().toLowerCase(Locale.ROOT) + ".com";
    }


    public int contador(){
        this.qtdViews ++;
        return qtdViews;
    }


    public int getQtdViews() {
        return qtdViews;
    }

    public void setQtdViews(int qtdViews) {
        this.qtdViews = qtdViews;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
