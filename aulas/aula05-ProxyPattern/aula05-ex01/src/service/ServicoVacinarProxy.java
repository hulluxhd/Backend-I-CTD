package service;

import java.util.Date;

public class ServicoVacinarProxy implements Vacinar{
    @Override
    public void vacinarPessoa(String nome,Date dataVacina, String vacina, String rg) {
        if (dataVacina.before(new Date())){
            ServicoVacinar servicoVacinar = new ServicoVacinar();
            servicoVacinar.vacinarPessoa(nome,dataVacina, vacina, rg);
        } else{
            System.out.println("A data de hoje é anterior à data marcada.");
        }
    }
}
