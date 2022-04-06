package com.hibernate.time.exerciciotime.service;

import com.hibernate.time.exerciciotime.model.Time;
import com.hibernate.time.exerciciotime.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeService {
    private TimeRepository timeRepository;
    @Autowired
    public TimeService(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    public Time salvar(Time time){
        return timeRepository.save(time);
    }
}
