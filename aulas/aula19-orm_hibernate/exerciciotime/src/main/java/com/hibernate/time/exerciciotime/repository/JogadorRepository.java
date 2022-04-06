package com.hibernate.time.exerciciotime.repository;

import com.hibernate.time.exerciciotime.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Integer> {

}
