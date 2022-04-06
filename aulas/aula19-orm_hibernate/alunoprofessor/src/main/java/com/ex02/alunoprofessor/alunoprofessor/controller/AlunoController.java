package com.ex02.alunoprofessor.alunoprofessor.controller;

import com.ex02.alunoprofessor.alunoprofessor.model.Aluno;
import com.ex02.alunoprofessor.alunoprofessor.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private AlunoService alunoService;
    @Autowired
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> listar(){
        return ResponseEntity.ok(alunoService.todos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarId(@PathVariable Integer id){
        return ResponseEntity.ok(alunoService.buscarId(id));
    }
    @PostMapping
    public ResponseEntity<Aluno> salvar(Aluno aluno){
        alunoService.salvar(aluno);
        return new ResponseEntity<Aluno>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteId(@PathVariable Integer id){
        alunoService.deleteId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
