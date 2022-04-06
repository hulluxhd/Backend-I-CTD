package com.ex02.alunoprofessor.alunoprofessor.controller;

import com.ex02.alunoprofessor.alunoprofessor.model.Aluno;
import com.ex02.alunoprofessor.alunoprofessor.model.Professor;
import com.ex02.alunoprofessor.alunoprofessor.service.AlunoService;
import com.ex02.alunoprofessor.alunoprofessor.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/professores")
public class ProfessorController {
    private ProfessorService professorService;
    @Autowired
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public ResponseEntity<List<Professor>> listar(){
        return ResponseEntity.ok(professorService.todos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarId(@PathVariable Integer id){
        return ResponseEntity.ok(professorService.buscarId(id));
    }
    @PostMapping
    public ResponseEntity<?> salvar(Professor professor){
        professorService.salvar(professor);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteId(@PathVariable Integer id){
        professorService.deleteId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
