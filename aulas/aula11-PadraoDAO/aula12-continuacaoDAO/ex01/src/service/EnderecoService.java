package service;

import dao.IDao;
import model.Endereco;

public class EnderecoService {
    // é a classe que conecta com a outra classe endereco, a que implementa os métodos da interface
    // é a classe que está mais perto do front-end, e é por onde faremos as solicitações ao servidor

    // instanciamos IDAO pois utilizaremos a classe EnderecoIDao e seus métodos
    // vai ficar assim quando chamarmos essa classe para trabalhar
    // EnderecoService enderecoService = new EnderecoService(new EnderecoDAOH2)
    private IDao<Endereco> enderecoIDao;

    public EnderecoService(IDao<Endereco> enderecoIDao) {
        this.enderecoIDao = enderecoIDao;
    }

    public Endereco salvar(Endereco endereco){
       enderecoIDao.salvar(endereco);
       return endereco;
    }

    public void deletar(Endereco endereco){
        enderecoIDao.delete(endereco);
    }

    public void pesquisar(int id){
        enderecoIDao.pesquisar(id);
    }
}
