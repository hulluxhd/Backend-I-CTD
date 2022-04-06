package com.dh.aula14.aulainiciospringboot.dao.service;

import com.dh.aula14.aulainiciospringboot.dao.config.ConfigJDBC;
import com.dh.aula14.aulainiciospringboot.dao.impl.PacienteDAOMySQL;
import com.dh.aula14.aulainiciospringboot.model.Paciente;

import java.util.List;
import java.util.Optional;

public class PacienteService {
    private PacienteDAOMySQL pacienteDAOMySQL;

    public  PacienteService() {
        this.pacienteDAOMySQL = new PacienteDAOMySQL();
    }

    public Paciente salvar(Paciente paciente){
        return pacienteDAOMySQL.salvar(paciente);
    }

    public Optional<Paciente> buscar(Integer id){
        return pacienteDAOMySQL.buscar(id);
    }

    public void excluir(Integer id){
        pacienteDAOMySQL.excluir(id);
    }

    public List<Paciente> buscarTodos(){
        return pacienteDAOMySQL.buscarTodos();
    }

    public Paciente atualizar(Paciente paciente){
        return pacienteDAOMySQL.atualizar(paciente);
    }

}
