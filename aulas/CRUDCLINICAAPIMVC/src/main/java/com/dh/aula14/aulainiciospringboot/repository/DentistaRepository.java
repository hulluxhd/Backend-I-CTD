package com.dh.aula14.aulainiciospringboot.repository;

import com.dh.aula14.aulainiciospringboot.model.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistaRepository extends JpaRepository<Dentista, Integer> {
}
