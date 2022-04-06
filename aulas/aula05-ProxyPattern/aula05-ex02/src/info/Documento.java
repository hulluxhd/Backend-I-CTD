package info;

import java.util.ArrayList;

public class Documento {
    String id, url, conteudo;
    ArrayList<String> listaUsuarios = new ArrayList<>();

    public Documento(String id, String url, String conteudo) {
        this.id = id;
        this.url = url;
        this.conteudo = conteudo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public ArrayList<String> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<String> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public void addEmail(String email){
        listaUsuarios.add(email);
    }

}
