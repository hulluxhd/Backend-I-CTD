package com.dh.aula14.aulainiciospringboot.dao.service;

import com.dh.aula14.aulainiciospringboot.dao.IDao;
import com.dh.aula14.aulainiciospringboot.model.Dentista;
import com.dh.aula14.aulainiciospringboot.model.Endereco;

import java.util.List;

public class EnderecoService {
    private IDao<Endereco> enderecoIDao;

    public EnderecoService(IDao<Endereco> enderecoIDao) {
        this.enderecoIDao = enderecoIDao;
    }

    public Endereco salvar(Endereco endereco){
        enderecoIDao.salvar(endereco);
        return endereco;
    }

    public void buscar(Endereco endereco){
        enderecoIDao.buscar(endereco.getId());
    }
    public void buscar(Integer id){
        enderecoIDao.buscar(id);
    }

    public List<Endereco> buscarTodos(){
        return enderecoIDao.buscarTodos();
    }

    public void delete(int id){
        enderecoIDao.excluir(id);
    }

}
