package com.ex.orm.hibernate.aprendendohibernate.repository;

import com.ex.orm.hibernate.aprendendohibernate.model.Mascote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascoteRepository extends JpaRepository<Mascote, Integer> {
}
