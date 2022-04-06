package com.dh.aula14.aulainiciospringboot.dao.service;

import com.dh.aula14.aulainiciospringboot.dao.IDao;
import com.dh.aula14.aulainiciospringboot.model.Dentista;
import com.dh.aula14.aulainiciospringboot.model.Usuario;

import java.util.List;

public class UsuarioService {

    private IDao<Usuario> usuarioIDao;

    public UsuarioService(IDao<Usuario> usuarioIDao) {
        this.usuarioIDao = usuarioIDao;
    }



    public Usuario salvar(Usuario usuario){
        usuarioIDao.salvar(usuario);
        return usuario;
    }

    public void buscar(Usuario usuario){
        usuarioIDao.buscar(usuario.getId());
    }
    public void buscar(Integer id){
        usuarioIDao.buscar(id);
    }

    public List<Usuario> buscarTodos(){
        return usuarioIDao.buscarTodos();
    }

    public void delete(int id){
        usuarioIDao.excluir(id);
    }

}
