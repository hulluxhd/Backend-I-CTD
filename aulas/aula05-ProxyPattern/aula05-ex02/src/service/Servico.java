package service;

import info.Documento;
import model.ServicoInterface;

public class Servico implements ServicoInterface {

    @Override
    public void acessarConteudo(String email, String url, Documento documento) {
        System.out.println("Conteúdo liberado: \n" + documento.getConteudo());
    }
}
