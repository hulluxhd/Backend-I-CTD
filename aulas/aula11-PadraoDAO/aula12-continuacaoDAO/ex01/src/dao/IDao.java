package dao;


// interface que protege o modelo de negócios
public interface IDao <T>{

    public T salvar(T t);
    public void delete(T t);
    public void pesquisar(int id);


}
