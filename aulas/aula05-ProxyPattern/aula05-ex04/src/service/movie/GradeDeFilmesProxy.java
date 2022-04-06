package service.movie;

import model.GradeDeFilmesInterface;
import user.Ip;

public class GradeDeFilmesProxy implements GradeDeFilmesInterface {

    private Ip ipDoUsuario;

    public GradeDeFilmesProxy(Ip ip) {
        this.ipDoUsuario = ip;
    }

    public Ip getIpDoUsuario() {
        return ipDoUsuario;
    }

    public void setIpDoUsuario(Ip ipDoUsuario) {
        this.ipDoUsuario = ipDoUsuario;
    }

    @Override
    public void getFilme(Movie nome) {
        String paisDoUsuario = definirPais(this.getIpDoUsuario());
        if (nome.getCountry() == paisDoUsuario){
            GradeDeFilmes gradeDeFilmes = new GradeDeFilmes();
            gradeDeFilmes.getFilme(nome);
        } else {
            System.out.println("Filme não disponível em seu país.");
        }

    }

    public String definirPais(Ip ip){
        if (ip.getIp() < 50) {return "Argentina";}
        else if(ip.getIp() < 100){return "Brazil";}
        else if (ip.getIp() < 150){return "Colombia";}
        else return null;
    }
}
