package dao;
// o T é um artifício que significa qualquer tipo de dado
public interface IDao<T> {
    public T salvar(T t);
}
