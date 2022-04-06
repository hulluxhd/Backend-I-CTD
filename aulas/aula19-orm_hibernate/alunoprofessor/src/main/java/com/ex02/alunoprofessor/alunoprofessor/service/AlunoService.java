package com.ex02.alunoprofessor.alunoprofessor.service;

import com.ex02.alunoprofessor.alunoprofessor.model.Aluno;
import com.ex02.alunoprofessor.alunoprofessor.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    @Autowired
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public void salvar(Aluno aluno){
        alunoRepository.save(aluno);
    }
    public List<Aluno> todos(){
        return alunoRepository.findAll();
    }

    public Optional<Aluno> buscarId(Integer id){
        return alunoRepository.findById(id);
    }

    public void deleteId(Integer id){
        alunoRepository.deleteById(id);
    }



}
