package com.dh.aula14.aulainiciospringboot.service;

import com.dh.aula14.aulainiciospringboot.model.Dentista;
import com.dh.aula14.aulainiciospringboot.repository.DentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistaService {
    @Autowired
    private DentistaRepository dentistaRepository;

    public Dentista salvar(Dentista dentista){
        return dentistaRepository.save(dentista);
    }

    public List<Dentista> mostrarTodos(){
        return dentistaRepository.findAll();
    }

    public Optional<Dentista> mostrarPorId(Integer id){
        return dentistaRepository.findById(id);
    }

    public void deletePorID(Integer id){
        dentistaRepository.deleteById(id);
    }

    public Dentista att(Dentista dentista){
        return dentistaRepository.save(dentista);
    }


}
