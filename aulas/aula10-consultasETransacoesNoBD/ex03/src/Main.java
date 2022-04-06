import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.sql.*;

public class Main {
    private static final String CREATE_TABLE =
            "DROP TABLE IF EXISTS dentista;" +
                    "CREATE TABLE DENTISTA(id int primary key, " +
                    "nome varchar(64), " +
                    "sobrenome varchar(64), " +
                    "matricula varchar(64));" ;
    private static final String INSERT = "" +
            "INSERT INTO dentista (id, nome, sobrenome, matricula) " +
            "VALUES" +
            "(?, ?, ? , ?);";
    private static final String UPDATE = "" +
            "UPDATE dentista SET matricula = ? WHERE id = ?";
    private static final String DELETE = "" +
            "DELETE FROM dentista WHERE id = ?;";


    private static final Logger logger = Logger.getLogger(Main.class);

    private static Connection getConnection() throws Exception{
        return DriverManager.getConnection("jdbc:h2:mem:ex");
    }

    private static void showTable(Connection connection) throws SQLException {
        Statement mostrar = connection.createStatement();
        ResultSet rs = mostrar.executeQuery("SELECT * FROM dentista;");
        rs.next();
        System.out.println(rs.getInt(1) + " - " +
                rs.getString(2)+ " - "+
                rs.getString(4));
    }

    private static void update(Connection connection, int id, String matricula) throws SQLException {
        PreparedStatement update = connection.prepareStatement(UPDATE);
        update.setString(1, matricula);
        update.setInt(2, id);
        update.execute();
        logger.info("Alteração bem sucedida...");
    }

    private static void delete(Connection connection, int id) throws Exception{
        PreparedStatement delete = connection.prepareStatement(DELETE);
        delete.setInt(1, id);
        delete.execute();
        logger.info("Registro deletado...");
    }

    public static void adicionar(Connection connection, int id, String nome, String sobrenome, String matricula) throws SQLException {
        PreparedStatement add = connection.prepareStatement(INSERT);
        add.setInt(1, id);
        add.setString(2, nome);
        add.setString(3, sobrenome);
        add.setString(4, matricula);
        add.execute();
        logger.info("Usuário " + nome + " adicionado ao BD...");
    }

    public static void main(String[] args) throws Exception{
        BasicConfigurator.configure();
        Connection connection = null;
        Dentista dentista = new Dentista(1, "Denny", "Ribeiro", "384109");
        Dentista dentista2 = new Dentista(2, "Joyce", "Leylane", "00000");

        try{
            connection = getConnection();
            Statement criarTabela = connection.createStatement();
            criarTabela.execute(CREATE_TABLE);
            adicionar
                    (connection,
                    dentista.getId(),
                    dentista.getNome(),
                    dentista.getSobrenome(),
                    dentista.getMatricula());

            try{
                connection.setAutoCommit(false);
                update(connection, dentista.getId(), "100102");
                connection.commit();
            } catch (Exception e){
                connection.rollback();
                logger.error("Erro no update...");
            } finally {
                connection.setAutoCommit(true);
            }
            showTable(connection);
            try{
                connection.setAutoCommit(false);
                delete(connection, 1);
                connection.commit();

            } catch (Exception e){
                logger.error("Erro na deleleção. Retornando ao ponto inicial. " + e);
            } finally {
                connection.setAutoCommit(true);
            }

            adicionar
                    (connection,
                    dentista2.getId(),
                    dentista2.getNome(),
                    dentista2.getSobrenome(),
                    dentista2.getMatricula());


        }
        catch (Exception e){

        }
        finally {
            showTable(connection);
            connection.close();
        }

        // adicionar dentista OK
        // update matricula OK
        // consultar matricula OK
        // delete id OK
        // consultar OK
    }
}
