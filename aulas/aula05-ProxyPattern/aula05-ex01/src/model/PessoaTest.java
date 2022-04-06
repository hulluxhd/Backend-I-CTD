package model;

import org.junit.jupiter.api.Test;
import service.ServicoVacinarProxy;
import service.Vacinar;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {
    Date dataHoje = new Date();
    @Test
    void TostandoAPessoa(){
        Pessoa p1 = new Pessoa("Denny não", "000000", "tô fora", dataHoje);
        Vacinar vacinar = new ServicoVacinarProxy();
        vacinar.vacinarPessoa(p1.getNome(), p1.getDataVacina(),p1.getVacina(), p1.getRg());
        System.out.println(p1.toString());
    }

}