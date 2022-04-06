package com.dh.aula14.aulainiciospringboot.dao.impl;

import com.dh.aula14.aulainiciospringboot.dao.IDao;
import com.dh.aula14.aulainiciospringboot.dao.config.ConfigJDBC;
import com.dh.aula14.aulainiciospringboot.model.Usuario;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioDaoMySQL implements IDao<Usuario> {

    private ConfigJDBC configJDBC;

    public UsuarioDaoMySQL() {
        configJDBC = new ConfigJDBC();
    }

    @Override
    public Usuario salvar(Usuario usuario) {

        Connection connection = configJDBC.conectarComBancoDeDados();
        PreparedStatement stmt = null;
        String query = String.format("INSERT INTO usuarios (" +
                "nome, email, senha, nivelAcesso) VALUES" +
                "('%s', '%s', '%s', '%s')",
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha(),
                usuario.getNivelAcesso());
        try{
            stmt = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.executeUpdate();
            ResultSet keys = stmt.getGeneratedKeys();
            if (keys.next()) usuario.setId(keys.getInt(1));
            stmt.close();
            connection.close();

        } catch (SQLException e){
            e.printStackTrace();
        }

        return usuario;
    }

    @Override
    public Optional<Usuario> buscar(Integer id) {
        Usuario usuario = null;
        Connection connection = configJDBC.conectarComBancoDeDados();
        PreparedStatement stmt = null;
        String query = String.format("SELECT * FROM usuarios WHERE id = '%s'", id);
        try{
            stmt = connection.prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next())
                usuario = new Usuario(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getInt(5));
            stmt.close();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return usuario != null ? Optional.of(usuario) : Optional.empty();
        // A classe Optional é utilizada para, em caso de erro, ocultá-lo, e
        // realizar alguns testes para averiguar se um retorno é correto
        // No caso acima, testamos se o usuario é diferente de null. Caso seja,
        // utilizamos o Optional.of que retornará a instância de usuario.
        // No caso do objeto ser nulo, com um id inexistente, por exemplo, retorna
        // objeto vazio.
    }

    @Override
    public void excluir(Integer id) {
        Connection connection = configJDBC.conectarComBancoDeDados();
        PreparedStatement stmt = null;
        String query = String.format("DELETE FROM usuarios WHERE id = '%s'", id);
        try{
            stmt = connection.prepareStatement(query);
            stmt.execute();
            stmt.close();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Usuario> buscarTodos() {
        List<Usuario> usuarioList = new ArrayList<>();

        Connection connection = configJDBC.conectarComBancoDeDados();
        PreparedStatement stmt = null;
        String query = "SELECT * FROM usuarios;";
        try{
            stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                usuarioList.add(new Usuario(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5)));

            }
            stmt.close();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public Usuario atualizar(Usuario usuario) {

        Connection connection = configJDBC.conectarComBancoDeDados();
        String query = String.format("UPDATE usuarios SET nome = '%s', " +
                "email = '%s', senha = '%s', nivelAcesso = '%s' WHERE id = '%s';",
                usuario.getNome(), usuario.getEmail(), usuario.getSenha(),
                usuario.getNivelAcesso(), usuario.getId());
        executarChamada(connection, query);

        return usuario;
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
