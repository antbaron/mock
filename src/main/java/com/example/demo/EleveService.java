package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EleveService {

    @Autowired
    private EleveRepository eleveRepository;


    public boolean isPositiveNote(int note) {
        return 0 <= note;
    }

    public int flolemaire(int note) {
        if (isPositiveNote(note) && note <= 20) {
            eleveRepository.addEleve(new Eleve("f", note));
            return eleveRepository.findMean("f");
        }
        return -1;


    }

    ;

}
