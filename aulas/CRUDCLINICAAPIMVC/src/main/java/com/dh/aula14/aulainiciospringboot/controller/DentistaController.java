package com.dh.aula14.aulainiciospringboot.controller;

import com.dh.aula14.aulainiciospringboot.service.DentistaService;
import com.dh.aula14.aulainiciospringboot.model.Dentista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController // Avisa que é um controller. Controller é a camada mais externa da applicação, e é o que o front tem
// acesso
@RequestMapping("/dentistas") // Avisa que está fazendo uma requisição de mapeamento da url passada como parâmetro
public class DentistaController {
    @Autowired
    private DentistaService dentistaService;


    @PostMapping
    public ResponseEntity<Dentista> salvar(@RequestBody Dentista dentista){
        return ResponseEntity.ok(dentistaService.salvar(dentista));
    }
    @GetMapping
    public ResponseEntity<List<Dentista>> mostrarTodos(){
        return ResponseEntity.ok(dentistaService.mostrarTodos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Dentista> mostrarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(dentistaService.mostrarPorId(id).orElse(null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        ResponseEntity rs = null;
        if (dentistaService.mostrarPorId(id).isPresent()){
            dentistaService.deletePorID(id);
            rs = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deletado");
        } else {
            rs = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return rs;
    }

    @PutMapping
    public ResponseEntity<Dentista> att(@RequestBody Dentista dentista){
        if (dentista.getId() != null && dentistaService.mostrarPorId(dentista.getId()).isPresent()){
            return ResponseEntity.ok(dentistaService.att(dentista));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
 }

