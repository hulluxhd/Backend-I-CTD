package test;

import dao.config.ConfigJDBC;
import dao.implement.EnderecoDAOH2;
import model.Endereco;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import service.EnderecoService;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class EnderecoServiceTest {
    private static final Logger logger = Logger.getLogger(EnderecoServiceTest.class);

    private EnderecoService enderecoService = new EnderecoService(new EnderecoDAOH2(new ConfigJDBC()));

    private final Endereco e1 = new Endereco(12, "rua 2", "Fortaleza", "CE");
    private final Endereco e2 = new Endereco(12212, "rua 12122", "Forta3213leza", "CE");


    @Test @Disabled
    public void teste(){
        try{
            Endereco endereco =  enderecoService.salvar(e1);

        } catch (Exception e){
            e.printStackTrace();

        }
        finally {
            System.out.println("Tudo certinho, endereço adicionado...");
        }

    }
    @Test
    public void deletar(){
        enderecoService.salvar(e2);
        enderecoService.pesquisar(e2.getId());
        //enderecoService.deletar(e2);

    }

}