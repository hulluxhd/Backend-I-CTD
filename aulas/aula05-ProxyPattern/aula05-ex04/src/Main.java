import service.movie.Movie;
import service.series.Serie;
import user.Ip;
import user.User;

public class Main {
    public static void main(String[] args) {
        Ip ip1 = new Ip(0);
        Ip ip2 = new Ip(50);
        Ip ip3 = new Ip(140);
        User usuario1 = new User("Denny", "teste@teste", ip1);
        User usuario2 = new User("Joyce", "teste@teste", ip2);
        User usuario3 = new User("Lucas", "teste@teste", ip3);
        Serie serie1 = new Serie("Two and a Half Men");
        Serie serie2 = new Serie("Battlestar Galactica");
        Movie Inception = new Movie("Inception", "Brazil", "htttps://wwwwww.wwww");
        Movie LOTR = new Movie("The Lord of The Rings", "Argentina", "htttps://wwwwww.wwww");
        Movie StarWars = new Movie("Star Wars", "Colombia", "htttps://wwwwww.wwww");
        usuario1.getFilme(Inception);
        usuario1.getFilme(LOTR);
        usuario1.getFilme(StarWars);
        System.out.println("*----------------------------------------*");
        usuario2.getFilme(Inception);
        usuario2.getFilme(LOTR);
        usuario2.getFilme(StarWars);
        System.out.println("*----------------------------------------*");
        usuario3.getFilme(Inception);
        usuario3.getFilme(LOTR);
        usuario3.getFilme(StarWars);
        System.out.println("*----------------------------------------*");
        usuario1.getSerie(serie1);
        usuario1.getSerie(serie2);
        System.out.println("*----------------------------------------*");
        usuario2.getSerie(serie1);
        usuario2.getSerie(serie2);
        System.out.println("*----------------------------------------*");
        usuario3.getSerie(serie1);
        usuario3.getSerie(serie2);
        usuario3.getSerie(serie2);
        usuario3.getSerie(serie2);
        usuario3.getSerie(serie2);
        usuario3.getSerie(serie2);
        System.out.println(serie2.getQtdViews());

    }
}
