package user;

import service.movie.GradeDeFilmesProxy;
import service.movie.Movie;
import service.series.Serie;
import service.series.SerieServiceProxy;

public class User {
    private String  name;
    private String email;
    private Ip ip;

    public User(String name, String email, Ip ip) {
        this.name = name;
        this.email = email;
        this.ip = ip;
    }

    public void getFilme(Movie nome){
        GradeDeFilmesProxy gradeDeFilmesProxy = new GradeDeFilmesProxy(this.getIp());
        gradeDeFilmesProxy.getFilme(nome);
    }

    public void getSerie(Serie nome){
        SerieServiceProxy s1 = new SerieServiceProxy();
        s1.getSerie(nome);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Ip getIp() {
        return ip;
    }

    public void setIp(Ip ip) {
        this.ip = ip;
    }
}
