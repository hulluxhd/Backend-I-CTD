import java.sql.*;

public class Main {
    // instruções SQL

    private static final String SQL_CREATE_TABLE = "" +
            "DROP TABLE IF EXISTS figura;" +
            "CREATE TABLE figura(" +
            "id int PRIMARY KEY NOT NULL, " +
            "tipo varchar(64) not null, " +
            "cor varchar(64) not null);";

    private static final String SQL_INSERT1 = "" +
            "INSERT INTO figura" +
            "(id, tipo, cor) VALUES (1, 'quadrado', 'vermelho')";
    private static final String SQL_INSERT2 = "" +
            "INSERT INTO figura" +
            "(id, tipo, cor) VALUES (2, 'triangulo', 'vermelho')";


    public static void main(String[] args) throws SQLException {
    Connection connection = null;

    try{
        connection = getConnection();
        Statement statement1 = connection.createStatement();
        statement1.execute(SQL_CREATE_TABLE);
        Statement statement2 = connection.createStatement();
        statement2.execute(SQL_INSERT1);
        Statement statement3 = connection.createStatement();
        statement3.execute(SQL_INSERT2);

        Statement select = connection.createStatement();
        ResultSet rs = select.executeQuery("SELECT * FROM figura WHERE cor = 'vermelho';");
        while(rs.next()){
            System.out.println(rs.getString(1) + " | " + rs.getString(2) + " | " + rs.getString(3));
        }

    }
    catch (Exception e){
        e.printStackTrace();
    }
    finally {
        connection.close();
    }


    }
    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection("jdbc:h2:mem:aulaDBExercicio", "sa", "");
    }
}

