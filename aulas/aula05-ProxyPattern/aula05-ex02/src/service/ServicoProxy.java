package service;

import info.Documento;
import model.ServicoInterface;

public class ServicoProxy implements ServicoInterface {

    @Override
    public void acessarConteudo(String email, String url, Documento documento) {
        if (documento.getListaUsuarios().indexOf(email) > -1){
            Servico s1 = new Servico();
            s1.acessarConteudo(email, url, documento);
        } else{
            System.out.println("Usuário sem permissão de acesso.");
        }
    }
}
