import java.security.cert.CRLException;
import java.sql.*;

public class Main {

    private static final String SQL_CREATE_TABLE = "" +
            "DROP TABLE IF EXISTS animal;" +
            "CREATE TABLE animal(" +
            "id int not null primary key," +
            "nome varchar(64)," +
            "tipo varchar(64));";

    private static final String INSERT1 = "" +
            "INSERT INTO animal(" +
            "id, nome, tipo) VALUES (" +
            "1, 'Dog1', 'cachorro')";
    private static final String INSERT2 = "" +
            "INSERT INTO animal(" +
            "id, nome, tipo) VALUES (" +
            "2, 'Gato1', 'gato')";
    private static final String INSERT3 = "" +
            "INSERT INTO animal(" +
            "id, nome, tipo) VALUES (" +
            "3, 'Dog2', 'cachorro')";
    private static final String INSERT4 = "" +
            "INSERT INTO animal(" +
            "id, nome, tipo) VALUES (" +
            "4, 'Gato2', 'gato')";
    private static final String INSERT5 = "" +
            "INSERT INTO animal(" +
            "id, nome, tipo) VALUES (" +
            "5, 'Dog3', 'cachorro')";


    public static void main(String[] args) throws Exception{
        Connection connection = null;

        try{
        connection = getConnection();

            Statement statement = connection.createStatement();
            Statement statement1 = connection.createStatement();
            Statement statement2 = connection.createStatement();
            Statement statement3 = connection.createStatement();
            Statement statement4 = connection.createStatement();
            Statement statement5 = connection.createStatement();

            statement.execute(SQL_CREATE_TABLE);
            statement1.execute(INSERT1);
            statement2.execute(INSERT2);
            statement3.execute(INSERT3);
            statement4.execute(INSERT4);
            statement5.execute(INSERT5);

            Statement select = connection.createStatement();

            ResultSet rs = select.executeQuery("SELECT * FROM animal;");
            while (rs.next()){
                System.out.println(rs.getInt(1) + " | " +
                        rs.getString(2) + " | " +
                        rs.getString(3));
            }
            select.execute("DELETE FROM animal WHERE id = 1;");
            ResultSet rs2 = select.executeQuery("SELECT * FROM animal;");
            while (rs2.next()){
                System.out.println(rs2.getInt(1) + " | " +
                        rs2.getString(2) + " | " +
                        rs2.getString(3));


        }}
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            connection.close();
        }

    }


    private static Connection getConnection() throws Exception {
        return DriverManager.getConnection("jdbc:h2:mem:aulaDBex03");
    }

}
