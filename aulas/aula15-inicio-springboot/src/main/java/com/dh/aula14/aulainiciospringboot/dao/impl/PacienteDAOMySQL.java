package com.dh.aula14.aulainiciospringboot.dao.impl;

import com.dh.aula14.aulainiciospringboot.dao.IDao;
import com.dh.aula14.aulainiciospringboot.dao.config.ConfigJDBC;
import com.dh.aula14.aulainiciospringboot.model.Paciente;
import com.dh.aula14.aulainiciospringboot.util.Utilitarios;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// BELEZA IRMÃO, É AQUI ONDE O NEGÓCIO FICA DIVERTIDO
// ESSA É A CLASSE QUE IRÁ TER PELO MENOS UMA CHAVE ESTRANGEIRA
public class PacienteDAOMySQL implements IDao<Paciente> {
    private ConfigJDBC configJDBC;
    private EnderecoDaoMySQL enderecoDaoMySQL;

    public PacienteDAOMySQL() {
        this.configJDBC = new ConfigJDBC();
        this.enderecoDaoMySQL = new EnderecoDaoMySQL();
    }

    @Override
    public Paciente salvar(Paciente paciente) {
        Connection conexao = configJDBC.conectarComBancoDeDados();
        PreparedStatement ptsmt = null;
        // Beleza, a linha de baixo é onde as coisas ficam malucas
        paciente.setEndereco(enderecoDaoMySQL.salvar(paciente.getEndereco()));
        //Estou setando o endereço de paciente NOVAMENTE, pois ele já foi setado
        // no momento de construção do paciente.
        // Estou chamando o método salvar lá da camada de acesso (DAO), passando
        // o endereço que cadastrei no paciente como parâmetro.
        // O método retorna um paciente, mas dessa vez COM O ID NO LUGAR CERTO, que
        // será então salvo novamente no endereço do paciente.
        // Quando precisarmos, agora, salvar o id no banco de dados como chave es-
        // trangeira, passamos o paciente.getEndereco().getId(). Irado, não?
        String query = String.format("INSERT INTO pacientes" +
                                     "(nome, sobrenome, cpf, dataCad, id_endereco) " +
                                     "VALUES " +
                                     "('%s', '%s', '%s', '%s', '%s')",
                                     paciente.getNome(),
                                     paciente.getSobrenome(),
                                     paciente.getCpf(),
                                     Utilitarios.dateToTimestamp(paciente.getDataCad()),
                                     paciente.getEndereco().getId());

        try{
            ptsmt = conexao.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ptsmt.executeUpdate();
            ResultSet key = ptsmt.getGeneratedKeys();
            if (key.next()) paciente.setId(key.getInt(1));
            ptsmt.close();
            conexao.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

        return paciente;
    }

    @Override
    public Optional<Paciente> buscar(Integer id) {
        Connection conexao = configJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        Paciente paciente = null;
        String query = String.format("SELECT * FROM pacientes WHERE id = '%s'", id);
        try{
            stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                paciente = criarObjetoPaciente(rs);
            }
            stmt.close();
            conexao.close();

        } catch (SQLException e){
            e.printStackTrace();
        }
        return paciente != null ? Optional.of(paciente) : Optional.empty();
    }



    @Override
    public void excluir(Integer id) {
        Connection conexao = configJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = String.format("DELETE FROM pacientes WHERE id = '%s'", id);
        Utilitarios.abrirConexaoEexecutarQuery(conexao, stmt, query);



    }

    @Override
    public List<Paciente> buscarTodos() {
        List<Paciente> pacienteList = new ArrayList<>();
        Connection conexao = configJDBC.conectarComBancoDeDados();
        PreparedStatement preparedStatement = null;
        String query = "SELECT * FROM pacientes;";
        try{
            preparedStatement = conexao.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                pacienteList.add(criarObjetoPaciente(rs));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }


        return pacienteList;
    }

    @Override
    public Paciente atualizar(Paciente paciente) {
        Connection conexao = configJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = String.format(
                "UPDATE pacientes SET nome = '%s', sobrenome = '%s', " +
                        "cpf = '%s' WHERE id = '%s'",
                paciente.getNome(),
                paciente.getSobrenome(),
                paciente.getCpf(),
                paciente.getId());

        if (paciente.getEndereco() != null && paciente.getId() != null){
            enderecoDaoMySQL.atualizar(paciente.getEndereco());
        }
        try{

            stmt = conexao.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            conexao.close();

        } catch (SQLException e){
            e.printStackTrace();
        }




        return paciente;
    }


    private Paciente criarObjetoPaciente(ResultSet rs) throws SQLException {
        return new Paciente(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getDate(5),
                enderecoDaoMySQL.buscar(rs.getInt(6)).orElse(null)
        );
    }
}
