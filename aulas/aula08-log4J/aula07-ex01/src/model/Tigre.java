package model;

import org.apache.log4j.Logger;

public class Tigre {
    private static final Logger logger = Logger.getLogger(Leao.class);
    private String nome;
    private int idade;

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

    public void correr(){
        logger.info("O tigre " + this.nome + " está corrento!");
    }

    public void eMaiorque10() throws Exception{
        if (idade > 10 ) {
            logger.info("O tigre " + nome + " é maior de 10 anos!");
        }
        if (idade < 0){
            logger.error("O tigre não pode ter idade negativa!");
            throw new Exception();
        }
    }
}
