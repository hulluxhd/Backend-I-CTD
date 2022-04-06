package model;

import java.util.Date;

public class Pessoa {
    private String nome;
    private String rg;
    private String vacina;
    private Date dataVacina;


    public Pessoa(String nome, String rg, String vacina, Date dataVacina) {
        this.nome = nome;
        this.rg = rg;
        this.vacina = vacina;
        this.dataVacina = dataVacina;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getVacina() {
        return vacina;
    }

    public void setVacina(String vacina) {
        this.vacina = vacina;
    }

    public Date getDataVacina() {
        return dataVacina;
    }

    public void setDataVacina(Date dataVacina) {
        this.dataVacina = dataVacina;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", rg='" + rg + '\'' +
                ", vacina='" + vacina + '\'' +
                ", dataVacina=" + dataVacina +
                '}';
    }
}


