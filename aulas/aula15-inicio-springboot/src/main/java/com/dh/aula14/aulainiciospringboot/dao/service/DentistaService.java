package com.dh.aula14.aulainiciospringboot.dao.service;

import com.dh.aula14.aulainiciospringboot.dao.IDao;
import com.dh.aula14.aulainiciospringboot.model.Dentista;

import java.util.List;

public class DentistaService {
    private IDao<Dentista> dentistaIDao;

    public DentistaService(IDao<Dentista> dentistaIDao) {
         this.dentistaIDao = dentistaIDao;
    }

    public Dentista salvar(Dentista dentista){
        dentistaIDao.salvar(dentista);
        return dentista;
    }

    public void buscar(Dentista dentista){
        dentistaIDao.buscar(dentista.getId());
    }
    public void buscar(Integer id){
        dentistaIDao.buscar(id);
    }

    public List<Dentista> buscarTodos(){
        return dentistaIDao.buscarTodos();
    }

    public void delete(int id){
        dentistaIDao.excluir(id);
    }


}
