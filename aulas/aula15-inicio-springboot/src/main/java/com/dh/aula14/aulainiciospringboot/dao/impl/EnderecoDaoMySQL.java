package com.dh.aula14.aulainiciospringboot.dao.impl;

import com.dh.aula14.aulainiciospringboot.dao.IDao;
import com.dh.aula14.aulainiciospringboot.dao.config.ConfigJDBC;
import com.dh.aula14.aulainiciospringboot.model.Dentista;
import com.dh.aula14.aulainiciospringboot.model.Endereco;
import com.dh.aula14.aulainiciospringboot.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EnderecoDaoMySQL implements IDao<Endereco> {

    private ConfigJDBC configJDBC;

    public EnderecoDaoMySQL() {
        configJDBC = new ConfigJDBC();
    }

    // CRUD

    // Create - salvar
    @Override
    public Endereco salvar(Endereco endereco) {
        // abrir conexão
        Connection connection = configJDBC.conectarComBancoDeDados();
        // preparar statement
        PreparedStatement pstmt = null;
        // montar a query
        String query = String.format("INSERT INTO " +
                        "enderecos " +
                        "(" +
                        "rua," +
                        "numero," +
                        "cidade, " +
                        "bairro," +
                        "estado) " +
                        "VALUES" +
                        "('%s', '%s', '%s', '%s', '%s')",
                endereco.getRua(),
                endereco.getNumero(),
                endereco.getCidade(),
                endereco.getBairro(),
                endereco.getEstado());
        try{
            // declara o statement
            pstmt = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.executeUpdate();
            // resgata o valor do id para poder salvar no dentista que foi cadastrado
            ResultSet keys = pstmt.getGeneratedKeys();
            // salva o id
            if(keys.next())
                endereco.setId(keys.getInt(1));
            pstmt.close();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return endereco;
    }

    // Consult - buscar
    @Override
    public Optional<Endereco> buscar(Integer id) {
        Endereco endereco = null;
        Connection connection = configJDBC.conectarComBancoDeDados();
        PreparedStatement pstmt = null;
        String query = String.format("SELECT * FROM enderecos WHERE id = '%s';", id);
        try{
            pstmt = connection.prepareStatement(query);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next())
                    endereco = new Endereco(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3),
                    resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
            pstmt.close();
            connection.close();

        } catch (SQLException e){
            e.printStackTrace();
        }
        return endereco != null ? Optional.of(endereco) : Optional.empty();
    }

    // Delete - excluir
    @Override
    public void excluir(Integer id) {
        Connection connection = configJDBC.conectarComBancoDeDados();
        PreparedStatement pstmt = null;
        String query = String.format("DELETE FROM enderecos WHERE id = '%s';", id);
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
    public List<Endereco> buscarTodos() {
        // abrir conexão
        Connection connection = configJDBC.conectarComBancoDeDados();
        PreparedStatement stmt = null;
        String query = "SELECT * FROM enderecos";
        List<Endereco> enderecoList = new ArrayList<>();
        try{
            stmt = connection.prepareStatement(query);
            ResultSet result = stmt.executeQuery();
            System.out.println(result);
            while (result.next()){
                enderecoList.add(criarObjetoEndereco(result));
            }
            stmt.close();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

        System.out.println(enderecoList);
        return enderecoList;
    }

    public Endereco criarObjetoEndereco(ResultSet rs) throws SQLException {
        return  new Endereco(
                rs.getInt("id"),
                rs.getString("rua"),
                rs.getInt("numero"),
                rs.getString("cidade"),
                rs.getString("bairro"),
                rs.getString("estado"));
    }

    // Update - atualizar
    @Override
    public Endereco atualizar(Endereco endereco) {

        Connection connection = configJDBC.conectarComBancoDeDados();
        String query = String.format("UPDATE enderecos SET rua = '%s', " +
                        "numero = '%s', cidade = '%s', bairro = '%s', " +
                        "cidade = '%s' " +
                        "WHERE id = '%s'",
                endereco.getRua(), endereco.getNumero(), endereco.getCidade(),
                endereco.getBairro(), endereco.getCidade(), endereco.getId());
        executarChamada(connection, query);

        return endereco;
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

