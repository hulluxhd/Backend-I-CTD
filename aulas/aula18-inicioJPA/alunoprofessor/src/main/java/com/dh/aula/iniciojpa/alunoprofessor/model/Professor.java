package com.dh.aula.iniciojpa.alunoprofessor.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String curso;
    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY)
    private Set<Aluno> alunos = new HashSet<>();


}
