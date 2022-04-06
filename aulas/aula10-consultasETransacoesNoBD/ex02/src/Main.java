import model.Paciente;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.sql.*;

public class Main {
    // instruções

    private static final String CREATE_TABLE = "" +
            "DROP TABLE IF EXISTS paciente;" +
            "CREATE TABLE paciente (" +
            "id int primary key not null, " +
            "nome varchar(64) not null, " +
            "sobrenome varchar(64) not null, " +
            "endereco varchar(64) not null, " +
            "rg varchar(64) not null, " +
            "dataCadastro varchar(64) not null," +
            "nomeUsuario varchar(64) not null," +
            "senha varchar(64) not null);";

    private static final String INSERT = "" +
            "INSERT INTO paciente (id, nome, sobrenome, endereco, rg, " +
            "dataCadastro, nomeUsuario, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String UPDATE ="" +
            "UPDATE paciente set senha = ? WHERE id = ?";

    private static Connection getConnection() throws Exception{
        return DriverManager.getConnection("jdbc:h2:mem:aula", "sa", "");
    }

    private static final Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) throws SQLException {
        BasicConfigurator.configure();

        Connection connection = null;
        Paciente paciente = new Paciente("Denny",
                "Ribeiro",
                "Avenida",
                "288228",
                "10/04/10",
                "Hullux",
                "lalala", 1);

        logger.info("Paciente criado...");

        try{
            connection = getConnection();
            logger.info("Conexão com o BD estabelecida...");
            Statement statement = connection.createStatement();
            statement.execute(CREATE_TABLE);
            logger.info("Tabela paciente criada...");
            PreparedStatement inserir = connection.prepareStatement(INSERT);
            inserir.setInt(1, paciente.getId());
            inserir.setString(2, paciente.getNome());
            inserir.setString(3, paciente.getSobrenome());
            inserir.setString(4, paciente.getEndereco());
            inserir.setString(5, paciente.getRg());
            inserir.setString(6, paciente.getDataCadastro());
            inserir.setString(7, paciente.getNomeUsuario());
            inserir.setString(8, paciente.getSenha());
            inserir.execute();
            logger.info("Paciente inserido na tabela...");

            connection.setAutoCommit(false);
            logger.info("Setando autocommit como false...");
            try{
                PreparedStatement update = connection.prepareStatement(UPDATE);
                update.setString(1, "NOVASENJHA");
                update.setInt(2, paciente.getId());
                update.execute();
                logger.info("Fazendo update na senha...");
                connection.commit();
            }
            catch (Exception e){
                logger.info("Erro! Rollback ativado!");
                connection.rollback();
                e.printStackTrace();
            }
            finally {
                connection.setAutoCommit(true);
                logger.info("Setando autocommit true...");
            }

            ResultSet rs = connection.createStatement().executeQuery("SELECT senha FROM paciente where id = " + paciente.getId() + ";");
            rs.next();
            logger.info("Senha do paciente: '" + rs.getString("senha") + "'.");

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            connection.close();
            logger.info("Encerrando conexão com o BD...");
        }








    }
}
