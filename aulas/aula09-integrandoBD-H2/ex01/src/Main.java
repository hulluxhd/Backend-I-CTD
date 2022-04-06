import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    private static final String SQL_CREATE_TABLE =
            "DROP TABLE IF EXISTS empregado;" +
            "CREATE TABLE empregado(" +
            "id int PRIMARY KEY not null," +
            "nome varchar(64) not null, " +
            "empresa varchar(64) not null," +
            "idade int," +
            "data_inicio varchar(64) not null)";

    private static final String SQL_INSERT1 =
            "INSERT INTO empregado" +
            "(id, nome, empresa, idade, data_inicio) VALUES " +
            "(1, 'Denny', 'Quero Dinheiro', 26, 'hoje')";

    private static final String SQL_INSERT2 =
            "INSERT INTO empregado" +
            "(id, nome, empresa, idade, data_inicio) VALUES " +
            "(2, 'Joyce', 'Fundacao Estudar', 25, '14/03/2022')";

    private static final String SQL_INSERT3 =
            "INSERT INTO empregado" +
            "(id, nome, empresa, idade, data_inicio) VALUES " +
            "(3, 'Thulio', 'Cruzeiro', 19, '22/05/2022')";



    public static void main(String[] args) throws Exception {
        // cria um atributo para instanciar a conexão
        Connection connection = null;
        try{
            // abre a conexão com o BD
            connection = getConnection();
            // Statement é uma interface que permite que as instruções de SQL sejam executadas
            // createStatement é um método que parametriza as instruções SQL para o BD
            Statement statement = connection.createStatement();
            // statement.execute() Retrieves the current result as a ResultSet object. This method should be called
            // only once per result.
            statement.execute(SQL_CREATE_TABLE);
            // Temos criar um atributo Statement para cada instrução a ser enviada.
            Statement statement1 = connection.createStatement();
            statement1.execute(SQL_INSERT1);
            Statement statement2 = connection.createStatement();
            statement2.execute(SQL_INSERT2);
            Statement statement3 = connection.createStatement();
            statement3.execute(SQL_INSERT3);

            // Fazendo um select nas informações inseridas
            Statement select = connection.createStatement();
            // ResultSet é uma tabela que representa os resultados de uma query, que é gerada executando um
            // statement que resolve uma instrução (de select geralmente?)
            ResultSet rs = select.executeQuery("SELECT * FROM empregado");
            // a linha acima está executando uma query, que é um statement (select), e guardando seu valor
            // em rs, que é uma tabela de resultados
            while (rs.next()){
                // rs guarda uma tabela. Contudo, para acessar suas informações deveremos ser específicos
                // o while, junto do método next(), varre a matriz, e enquanto houver linhas disponíveis
                // vai continuar executando.
                System.out.println(rs.getInt("id") + " | " +
                        rs.getString("nome") + " | " +
                        rs.getString("empresa") + " | " +
                        rs.getInt("idade") + " | " +
                        rs.getString("data_inicio"));
                // o java é chato pra caralho, e todo o output deve ser definido em seu tipo
                //
            }
            // o processo de criação e envio, portanto, é:
            // 1. abrir a conexão com o BD (getConnection)
            // 2. criar um objeto de Statement (connection.createStatement())
            // 3. executar a instrução SQL (execute()) para cada instrução

        }
        catch (Exception e){
            // printa o erro e
            e.printStackTrace();
        }
        finally {
            connection.close();
        }

    }

    public static Connection getConnection() throws Exception{
        // cria a conexão com o banco de dados. DriverManager é a classe padrão para acessar o JDBD e fazer
        // conexões.
        // o getConnection tenta fazer a conexão com a BD passado pela url
        return DriverManager.getConnection("jdbc:h2:mem:aulaBD", "sa", "");
    }
}
