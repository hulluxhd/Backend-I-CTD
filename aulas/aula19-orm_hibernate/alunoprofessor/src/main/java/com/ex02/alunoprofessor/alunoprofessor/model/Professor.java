package com.ex02.alunoprofessor.alunoprofessor.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String curso;
    @ManyToOne(fetch = FetchType.LAZY)
    private Set<Aluno> alunos = new HashSet<>();

    public Professor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
