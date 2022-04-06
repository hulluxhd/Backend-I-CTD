package com.hibernate.time.exerciciotime.repository;

import com.hibernate.time.exerciciotime.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepository extends JpaRepository<Time, Integer> {
}
