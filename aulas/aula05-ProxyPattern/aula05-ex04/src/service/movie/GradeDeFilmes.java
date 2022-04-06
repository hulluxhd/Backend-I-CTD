package service.movie;

import model.GradeDeFilmesInterface;

public class GradeDeFilmes implements GradeDeFilmesInterface {

    @Override
    public void getFilme(Movie nome) {
        System.out.println(nome);
    }
}
