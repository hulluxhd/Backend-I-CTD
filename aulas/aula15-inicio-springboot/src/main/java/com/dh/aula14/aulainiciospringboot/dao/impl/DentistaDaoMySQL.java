package com.dh.aula14.aulainiciospringboot.dao.impl;
import com.dh.aula14.aulainiciospringboot.dao.IDao;
import com.dh.aula14.aulainiciospringboot.dao.config.ConfigJDBC;
import com.dh.aula14.aulainiciospringboot.model.Dentista;
import com.dh.aula14.aulainiciospringboot.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
// impl é o pacote que irá implentar os métodos de DAO
public class DentistaDaoMySQL implements IDao<Dentista> {

    private ConfigJDBC configJDBC;
    // pra poder fazer qualquer operação no banco, primeiro deve-se abrir a conexão
    // com o mesmo;
    // o construtor já deixa uma conexão, restando apenas chamar seu método
    public DentistaDaoMySQL() {
        this.configJDBC = new ConfigJDBC();
    }

    // CRUD

    // Create - salvar
    @Override
    public Dentista salvar(Dentista dentista) {
        // abrir conexão
        Connection connection = configJDBC.conectarComBancoDeDados();
        // preparar statement
        PreparedStatement pstmt = null;
        // montar a query
        String query = String.format("INSERT INTO " +
                        "dentistas " +
                        "(" +
                        "nome," +
                        "email," +
                        "numMatricula, " +
                        "atendeConvenio" +
                        ") " +
                        "VALUES" +
                        "('%s', '%s', '%s', '%s')",
                dentista.getNome(),
                dentista.getEmail(),
                dentista.getNumMatricula(),
                dentista.getAtendeConvenio());
        try{
            // declara o statement
            pstmt = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.executeUpdate();
            // resgata o valor do id para poder salvar no dentista que foi cadastrado
            ResultSet keys = pstmt.getGeneratedKeys();
            // salva o id
            if(keys.next())
                dentista.setId(keys.getInt(1));
            pstmt.close();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return dentista;
    }

    // Consult - buscar
    @Override
    public Optional<Dentista> buscar(Integer id) {
        Dentista dentista = null;
        Connection connection = configJDBC.conectarComBancoDeDados();
        PreparedStatement pstmt = null;
        String query = String.format("SELECT * FROM dentistas WHERE id = '%s';", id);
        try{
            pstmt = connection.prepareStatement(query);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) dentista = new Dentista(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4), resultSet.getInt(5));
            pstmt.close();
            connection.close();

        } catch (SQLException e){
            e.printStackTrace();
        }
        return dentista != null ? Optional.of(dentista) : Optional.empty();
    }

    // Delete - excluir
    @Override
    public void excluir(Integer id) {
        Connection connection = configJDBC.conectarComBancoDeDados();
        PreparedStatement pstmt = null;
        String query = String.format("DELETE FROM dentistas WHERE id = '%s';", id);
        try{
            pstmt = connection.prepareStatement(query);
            pstmt.execute();
            pstmt.close();
            connection.close();
        System.out.println("deletado");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    // Consult * - buscarTodos
    @Override
    public List<Dentista> buscarTodos() {
        // abrir conexão
        Connection connection = configJDBC.conectarComBancoDeDados();
        PreparedStatement stmt = null;
        String query = "SELECT * FROM dentistas";
        List<Dentista> dentistaList = new ArrayList<>();
        try{
            stmt = connection.prepareStatement(query);
            ResultSet result = stmt.executeQuery();
            System.out.println(result);
            while (result.next()){
                dentistaList.add(criarObjetoDentista(result));
            }
            stmt.close();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

        System.out.println(dentistaList);
        return dentistaList;
    }

    public Dentista criarObjetoDentista(ResultSet rs) throws SQLException {
        return  new Dentista(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("email"),
                rs.getInt("numMatricula"),
                rs.getInt("atendeConvenio"));
    }

    // Update - atualizar
    @Override
    public Dentista atualizar(Dentista dentista) {
        Connection connection = configJDBC.conectarComBancoDeDados();
        String query = String.format(
                "UPDATE " +
                "enderecos SET nome = '%s', " +
                "email = '%s', " +
                "numMatricula = '%s', " +
                "atendeConvenio = '%s', " +
                "WHERE id = '%s'",
                dentista.getNome(), dentista.getEmail(), dentista.getNumMatricula(),
                dentista.getAtendeConvenio(), dentista.getId()
        );
        executarChamada(connection, query);
        return dentista;
    }

    private void executarChamada(Connection connection, String query) {
        try{
            Statement stmt = connection.createStatement();
            stmt.execute(query);
            stmt.close();
            connection.close();

        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
}
