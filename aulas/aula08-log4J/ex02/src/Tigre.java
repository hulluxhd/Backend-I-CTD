import org.apache.log4j.Logger;

public class Tigre {
    private String nome;
    private int idade;
    private static final Logger logger = Logger.getLogger(Leao.class);

    public Tigre(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
}
