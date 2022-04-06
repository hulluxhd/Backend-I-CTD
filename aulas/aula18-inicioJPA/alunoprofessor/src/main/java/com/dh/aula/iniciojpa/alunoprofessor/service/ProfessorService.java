package com.dh.aula.iniciojpa.alunoprofessor.service;

import com.dh.aula.iniciojpa.alunoprofessor.model.Professor;
import com.dh.aula.iniciojpa.alunoprofessor.repository.ProfessorRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {
    @Autowired
    private final ProfessorRespository professorRespository;

    public ProfessorService(ProfessorRespository professorRespository) {
        this.professorRespository = professorRespository;
    }

    public void teste(){
        professorRespository.save(Professor.class);
    }
}
