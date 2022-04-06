import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {
    Pessoa p1, p2, p3, p4, p5, p6, p7, p8, p9, p10;
    List<String> colecao = new ArrayList<String>();

    @BeforeEach
    void doBefore(){
        p1 = new Pessoa("Denny");
        p1.setIdade(LocalDate.of(1995,3,22));
        p2 = new Pessoa("Deny");
        p2.setIdade(LocalDate.of(2008,3,22));
        p3 = new Pessoa("Den");
        p3.setIdade(LocalDate.of(2006,3,22));
        p4 = new Pessoa("De");
        p4.setIdade(LocalDate.of(2004,3,22));
        p5 = new Pessoa("D");
        p5.setIdade(LocalDate.of(2002,3,22));
        p6 = new Pessoa("Joyce");
        p6.setIdade(LocalDate.of(2000,3,22));
        p7 = new Pessoa("Joyc");
        p7.setIdade(LocalDate.of(2003,3,22));
        p8 = new Pessoa("Joy");
        p8.setIdade(LocalDate.of(2004,3,22));
        p9 = new Pessoa("Jo");
        p9.setIdade(LocalDate.of(2005,3,22));
        p10 = new Pessoa("J");
        p10.setIdade(LocalDate.of(2012,3,22));
    }
    @Test
    void imprimirObj(){
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
        System.out.println(p4.toString());
        System.out.println(p5.toString());
        System.out.println(p6.toString());
        System.out.println(p7.toString());
        System.out.println(p8.toString());
        System.out.println(p9.toString());
        System.out.println(p10.toString());
    }
    @Test
    void adicionarColecao(){
        p1.adicionarNome(p1);
        p2.adicionarNome(p2);
        p3.adicionarNome(p3);
        p4.adicionarNome(p4);
        p5.adicionarNome(p5);
        p6.adicionarNome(p6);
        p7.adicionarNome(p7);
        p8.adicionarNome(p8);
        p9.adicionarNome(p9);
        p10.adicionarNome(p10);
    }

    @Test
    void isValid(){
        assertTrue(p1.getNomes().size() == 1);
    }
}