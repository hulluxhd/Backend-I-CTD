package com.dh.aula14.aulainiciospringboot.model;

import java.util.Date;

public class Consulta {

    private Integer id;
    private Paciente paciente;
    private Dentista dentista;
    private Usuario usuario;
    private Date dataCad;


    public Consulta(Integer id, Paciente paciente, Dentista dentista, Usuario usuario, Date dataCad) {
        this.id = id;
        this.paciente = paciente;
        this.dentista = dentista;
        this.usuario = usuario;
        this.dataCad = dataCad;
    }

    public Consulta(Paciente paciente, Dentista dentista, Usuario usuario, Date dataCad) {
        this.paciente = paciente;
        this.dentista = dentista;
        this.usuario = usuario;
        this.dataCad = dataCad;
    }

    public Consulta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataCad() {
        return dataCad;
    }

    public void setDataCad(Date dataCad) {
        this.dataCad = dataCad;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "id=" + id +
                ", paciente=" + paciente +
                ", dentista=" + dentista +
                ", usuario=" + usuario +
                ", dataCad=" + dataCad +
                '}';
    }
}
