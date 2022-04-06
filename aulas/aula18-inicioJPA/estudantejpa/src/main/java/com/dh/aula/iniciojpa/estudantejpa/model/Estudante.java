package com.dh.aula.iniciojpa.estudantejpa.model;

import javax.persistence.*;

@Entity
@Table
public class Estudante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String sobrenome;
    private String email;


}
