package com.dh.aula14.aulainiciospringboot.dao;

import java.util.List;
import java.util.Optional;
// CRUDZÃO DA MASSA
public interface IDao<T> {
    public T salvar(T t);
    public Optional<T> buscar(Integer id);
    public void excluir(Integer id);
    public List<T> buscarTodos();
    public T atualizar(T t);
}
