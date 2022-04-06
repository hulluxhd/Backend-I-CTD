package com.ex.orm.hibernate.aprendendohibernate.controller;

import com.ex.orm.hibernate.aprendendohibernate.model.Produto;
import com.ex.orm.hibernate.aprendendohibernate.service.ProdutoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoServiceImpl produtoServiceImpl;

    @Autowired
    public ProdutoController(ProdutoServiceImpl produtoServiceImpl) {
        this.produtoServiceImpl = produtoServiceImpl;
    }


    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Produto produto){
        produtoServiceImpl.salvar(produto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> buscarTodos(){

        return ResponseEntity.ok(produtoServiceImpl.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produto>> buscarId(@PathVariable Integer id){
        return ResponseEntity.ok(produtoServiceImpl.buscarId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPorId(@PathVariable Integer id){
        produtoServiceImpl.deletar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
