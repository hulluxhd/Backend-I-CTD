package com.hibernate.time.exerciciotime.controller;

import com.hibernate.time.exerciciotime.model.Time;
import com.hibernate.time.exerciciotime.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/times")
public class TimeController {
    private final TimeService timeService;
    @Autowired
    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @PostMapping
    public ResponseEntity<Time> salvar(@RequestBody Time time){

        return ResponseEntity.ok(timeService.salvar(time));
    }
}
