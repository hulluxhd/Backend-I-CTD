package service;

import model.Conta;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.sql.*;

public class ContaService {
    private static final Logger logger = Logger.getLogger(ContaService.class);

    private static final String SQL_CREATE = "DROP TABLE IF EXISTS conta;" +
            "CREATE TABLE conta(" +
            "id int primary key not null, " +
            "nome varchar(64), " +
            "numCartao varchar(64), " +
            "saldo double NOT NULL);" ;
    private static final String INSERT = "" +
            "INSERT INTO conta(id, nome, numCartao, saldo) VALUES (?, ?, ?, ?)";

    private static final String UPDATE = "" +
            "UPDATE conta SET saldo = ? WHERE id = ?";

    public static double pegarSaldoAtual(Connection connection) throws SQLException {
        ResultSet result = connection.createStatement().executeQuery("SELECT * FROM conta;");
        result.next();
        double valor = result.getDouble(4);
        return valor;
    }

    public static void atualizarSaldo(Connection connection, double adicionar) throws SQLException {
        PreparedStatement atualizar = connection.prepareStatement(UPDATE);
        double novoValor = pegarSaldoAtual(connection) + adicionar;
        atualizar.setDouble(1, novoValor);
        atualizar.setInt(2, 1);
        atualizar.execute();
        logger.info("Atualizando... adicionando R$" + novoValor);
        mostrarResultados(connection);

    }

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection("jdbc:h2:mem:aula10", "sa", "");
    }

    public static void mostrarResultados(Connection connection) throws SQLException {
        ResultSet result = connection.createStatement().executeQuery("SELECT * FROM conta;");
        while (result.next()){
            System.out.println("ID: " + result.getInt(1) + " Nome: " +
                    result.getString(2) + " Numero da conta: " + result.getString(3) +
                    " Saldo: " + result.getDouble(4));
        }
    }

    public static void main(String[] args) throws Exception {
        BasicConfigurator.configure();
        Connection connection = null;
        Conta c1 = new Conta(1, "Denny", "2233344", 0.0);
        try{
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE);
            logger.info("Tabela criada...");
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setInt(1, c1.getId());
            preparedStatement.setString(2, c1.getNome());
            preparedStatement.setString(3, c1.getNumConta());
            preparedStatement.setDouble(4, c1.getSaldo());
            logger.info("Inserindo usuário no BD...");
            preparedStatement.execute();
            mostrarResultados(connection);

            // fazendo o update
            PreparedStatement preparedStatement1 = connection.prepareStatement(UPDATE);
            preparedStatement1.setDouble(1, 10.0);
            preparedStatement1.setInt(2, 1);
            preparedStatement1.execute();
            logger.info("Fazendo o update...");
            atualizarSaldo(connection, 15);
            atualizarSaldo(connection, 25);
            logger.info("Saldo atual: R$" + pegarSaldoAtual(connection));




        }
        catch (Exception e){
            logger.error("Erro no try: " + e);

        }
        finally {
            connection.close();
            logger.info("Encerrando BD...");
        }

    }
}
