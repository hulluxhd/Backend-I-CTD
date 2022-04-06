package com.ex02.alunoprofessor.alunoprofessor.service;

import com.ex02.alunoprofessor.alunoprofessor.model.Professor;
import com.ex02.alunoprofessor.alunoprofessor.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    private ProfessorRepository professorRepository;
    @Autowired
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public void salvar(Professor professor){
        professorRepository.save(professor);
    }
    public List<Professor> todos(){
        return professorRepository.findAll();
    }

    public Optional<Professor> buscarId(Integer id){
        return professorRepository.findById(id);
    }

    public void deleteId(Integer id){
        professorRepository.deleteById(id);
    }

}
