import org.apache.log4j.Logger;

public class Leao {
    private String nome;
    private int idade;
    private boolean isAlpha;
    private static final Logger logger = Logger.getLogger(Leao.class);

    public Leao(String nome, int idade, boolean isAlpha) {
        this.nome = nome;
        this.idade = idade;
        this.isAlpha = isAlpha;
    }

    public void correr() throws Exception{
        logger.info("O leão " + nome + "  está correndo!");
    }

    public void maior10() throws Exception{
        if (this.idade > 10 && isAlpha){
            logger.info("O leão " + nome + " é alphazão e maior de idade. Pode pegar as novinhas.");
        }
        if (idade < 0){
            logger.error("A idade não pode ser negativa");
            throw new Exception();
        }
    }
}
