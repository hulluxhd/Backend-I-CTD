package dao;

import model.Hotel;

public interface IDao<T> {
    public T salvar(T t);
}
