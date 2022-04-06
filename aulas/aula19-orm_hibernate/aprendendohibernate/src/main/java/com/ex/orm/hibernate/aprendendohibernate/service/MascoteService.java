package com.ex.orm.hibernate.aprendendohibernate.service;

import com.ex.orm.hibernate.aprendendohibernate.repository.MascoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MascoteService {
    @Autowired
    private MascoteRepository mascoteRepository;

    public void teste(){

    }


}
