package dao.implement;

import dao.IDao;
import dao.config.ConfigJDBC;
import model.Endereco;
import java.sql.*;

// classe que implementa a interface DAO. Para construir usando outro motor
// de banco de dados, bastaria abrir uma nova classe e usar as configurações
// da classe JDBC

// Essa é a classe que faz o registro no banco de dados. O construtor terá uma
// conexão com o banco de dados, e o método guardará a informação que queremos
public class EnderecoDAOH2 implements IDao<Endereco> {
    private ConfigJDBC configJDBC;

    public EnderecoDAOH2(ConfigJDBC configJDBC) {
        this.configJDBC = configJDBC;
    }


    @Override
    public Endereco salvar(Endereco endereco) {
        // variáveis de conexão e statement, além do comando para esse método (INSERT)
        Connection conexao = configJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String query = String.format(
                "INSERT INTO enderecos (numero, rua, cidade, estado) " +
                        "VALUES ('%s', '%s', '%s', '%s');",
                endereco.getNumero(),
                endereco.getRua(),
                endereco.getCidade(),
                endereco.getEstado()
        );
        try {
            statement = conexao.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            // o return_generated_keys irá deixar a chave que foi cadastrada no banco
            // de dados (auto_increment) disponível para ser recuperada, e
            // posteriormente colocar de volta no objeto, como abaixo

            ResultSet keys = statement.getGeneratedKeys(); // recupera as chaves geradas
            if (keys.next())
                endereco.setId(keys.getInt(1)); // coloca o id dentro do endereco
            statement.close();
            conexao.close();
        }
        catch(SQLException e){
        e.printStackTrace();
    }
        System.out.println("Fodendo salvo...");
        return endereco;
}

        @Override
    public void delete(Endereco endereco) {
        Connection conexao = configJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String query = String.format(
                "DELETE FROM enderecos WHERE id = '%s'",
                endereco.getId()
        );

        try{
            statement = conexao.createStatement();
            statement.execute(query);
            System.out.println("Endereço deletado!");
            statement.close();
            conexao.close();
         }
        catch (SQLException e){
            e.printStackTrace();
        }

}

    @Override
    public void pesquisar(int id) {
        Connection conexao = configJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String query = String.format(
                "SELECT * FROM enderecos WHERE id = '%s';",
                id
        );
        try{
            statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(query);

            System.out.println(rs);
            while (rs.next()){
                System.out.println(rs.getInt(1) + " " +
                        rs.getString(2) + " " +
                        rs.getString(3) + " " +
                        rs.getString(4) + " " +
                        rs.getString(5)
                        );
            }
            statement.close();
            conexao.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
