package com.ex02.alunoprofessor.alunoprofessor.repository;

import com.ex02.alunoprofessor.alunoprofessor.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
