package com.ex.orm.hibernate.aprendendohibernate.repository;

import com.ex.orm.hibernate.aprendendohibernate.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
