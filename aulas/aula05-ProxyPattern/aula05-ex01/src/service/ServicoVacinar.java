package service;

import java.util.Date;

public class ServicoVacinar implements Vacinar{

    @Override
    public void vacinarPessoa(String nome, Date dataVacina, String vacina, String rg) {
        System.out.println("Usuário " + nome + "encomendado em " + dataVacina + " com a vacina da morte " + vacina);
    }
}
