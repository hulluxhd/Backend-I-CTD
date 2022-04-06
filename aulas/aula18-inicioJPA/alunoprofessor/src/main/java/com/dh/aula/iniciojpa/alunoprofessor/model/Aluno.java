package com.dh.aula.iniciojpa.alunoprofessor.model;

import javax.persistence.*;

@Entity
@Table
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome, idade;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "professor_id")
    private Professor professor;
    public Aluno() {
    }
}
