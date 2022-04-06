package com.dh.aula.iniciojpa.alunoprofessor.repository;

import com.dh.aula.iniciojpa.alunoprofessor.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRespository extends JpaRepository<Professor, Integer> {
}
