package com.ex.orm.hibernate.aprendendohibernate.service;

import com.ex.orm.hibernate.aprendendohibernate.model.Produto;
import com.ex.orm.hibernate.aprendendohibernate.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl{

    private final ProdutoRepository produtoRepository;
    @Autowired
    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void salvar(Produto produto) {
        produtoRepository.save(produto);
    }

    public List<Produto> buscarTodos(){
      return  produtoRepository.findAll();
    }

    public void deletar(Integer id){
        produtoRepository.deleteById(id);
    }

    public Optional<Produto> buscarId(Integer id){
      return  produtoRepository.findById(id);
    }

}
