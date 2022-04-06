package com.dh.aula14.aulainiciospringboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dentista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer numMatricula;
    private Integer atendeConvenio;
    private String nome, email;





    public Dentista(Integer id, String nome, String email, Integer numMatricula, Integer atendeConvenio) {
        this.id = id;
        this.numMatricula = numMatricula;
        this.atendeConvenio = atendeConvenio;
        this.nome = nome;
        this.email = email;
    }

    public Dentista(String nome, String email, Integer numMatricula, Integer atendeConvenio) {
        this.numMatricula = numMatricula;
        this.atendeConvenio = atendeConvenio;
        this.nome = nome;
        this.email = email;
    }

    public Dentista() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(Integer numMatricula) {
        this.numMatricula = numMatricula;
    }

    public Integer getAtendeConvenio() {
        return atendeConvenio;
    }

    public void setAtendeConvenio(Integer atendeConvenio) {
        this.atendeConvenio = atendeConvenio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Dentista{" +
                "id=" + id +
                ", numMatricula=" + numMatricula +
                ", atendeConvenio=" + atendeConvenio +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
