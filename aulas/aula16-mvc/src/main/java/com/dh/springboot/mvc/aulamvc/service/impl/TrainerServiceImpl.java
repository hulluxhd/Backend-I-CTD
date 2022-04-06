package com.dh.springboot.mvc.aulamvc.service.impl;

import com.dh.springboot.mvc.aulamvc.model.Trainer;
import com.dh.springboot.mvc.aulamvc.service.TrainerService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {
    @Override
    public List<Trainer> listTrainer() {
        return Arrays.asList(
                new Trainer("Denny"),
                new Trainer("Lucas"),
                new Trainer("Joyce")
        );
    }
}
