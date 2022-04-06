import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.sql.*;

public class Main {
    // log4j
    private static final Logger logger = Logger.getLogger(Main.class);
    // INSTRUÇÕES SQL
    private static final String SQL_CREATE_TABLE = "" +
            "DROP TABLE IF EXISTS usuario;" +
            "CREATE TABLE usuario(id int primary key, " +
            "nome varchar(64) not null, " +
            "sobrenome varchar(64) not null, " +
            "idade int not null);" +
            "";

    private static final String INSERT1 = "" +
            "INSERT INTO usuario(" +
            "id, nome, sobrenome, idade) VALUES " +
            "(1, 'Jhon', 'Lennon', 34);";

    private static final String INSERT2 = "" +
            "INSERT INTO usuario(" +
            "id, nome, sobrenome, idade) VALUES " +
            "(2, 'Lemon', 'Sigfried', 45);";

    private static final String INSERT3 = "" +
            "INSERT INTO usuario(" +
            "id, nome, sobrenome, idade) VALUES " +
            "(3, 'Lionel', 'Richie', 31);";
    private static final String INSERT4 = "" +
            "INSERT INTO usuario(" +
            "id, nome, sobrenome, idade) VALUES " +
            "(4, 'Brad', 'Pit', 32);";

    private static final String SQL_DELETE = "" +
            "DELETE FROM usuario WHERE id = 2";

    private static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:mem:aula12", "sa", "");
    }

    public static void main(String[] args) throws Exception{
        //configurando o log4j
        BasicConfigurator.configure();
        Connection connection = null;
        try{
            connection = getConnection();

            Statement statement = connection.createStatement();

            statement.execute(SQL_CREATE_TABLE);
            logger.info("Criando o BD");
            statement.execute(INSERT1);
            logger.info("Instrução 1");
            statement.execute(INSERT2);
            logger.info("Instrução 2");
            statement.execute(INSERT3);
            logger.info("Instrução 3");
            statement.execute(INSERT4);
            logger.info("Instrução 4");

            showResults(connection);

            deleting(connection, 4);

        } catch (Exception e){
            logger.error("Erro na execução do bloco Try: ", e);
        } finally {
            if (connection == null){ return;}
            connection.close();
        }

    }
    public static void deleting(Connection connection, int id) throws Exception{
        String DEL = "DELETE FROM usuario WHERE nome = " + id + ";";
        String SELECTNEWTABLE = "SELECT * FROM usuario;";
        connection.createStatement().execute(DEL);
        ResultSet rs = connection.createStatement().executeQuery(SELECTNEWTABLE);
        logger.info("Usuário de id: " + id + " -> deletado da tabela");
        logger.info("Exibindo a tabela...");
        while (rs.next()){
            System.out.println(rs.getInt("id") + " | " +
                    rs.getString("nome")+ " | " +
                    rs.getString("sobrenome")+ " | " +
                    rs.getInt("idade"));
        }
    }

    public static void showResults(Connection connection) throws Exception{
         String SQLINSTRUCTION = "SELECT * FROM usuario;";
         ResultSet rs = connection.createStatement().executeQuery(SQLINSTRUCTION);
         while (rs.next()){
             System.out.println(rs.getInt("id") + " | " +
                     rs.getString("nome")+ " | " +
                     rs.getString("sobrenome")+ " | " +
                     rs.getInt("idade"));
         }

    }
}
