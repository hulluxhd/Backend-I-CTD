package model;


import org.apache.log4j.Logger;

public class Leao {
    private static final Logger logger = Logger.getLogger(Leao.class);
    private String nome;
    private int idade;
    private boolean isAlpha;



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean isAlpha() {
        return isAlpha;
    }

    public void setAlpha(boolean alpha) {
        isAlpha = alpha;
    }

    public void correr(){
    logger.info("O leão " + this.nome + " está corrento!");
    }

    public void eMaiorque10() throws Exception{
        if (idade > 10 && isAlpha) {
            logger.info("O leão " + nome + " é maior de 10 anos!");
        }
        if (idade < 0){
            logger.error("O leão não pode ter idade negativa!");
            throw new Exception();
        }
    }

}
