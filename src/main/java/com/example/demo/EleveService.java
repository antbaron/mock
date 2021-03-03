package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EleveService {

	@Autowired
	private EleveRepository eleveRepository;
	

	public boolean isPositiveNote(int note) {
		return 0 < note;
	}
	
	public int anthony(int note){
		if (isPositiveNote(note) && note < 20){
            Eleve nouvelEleve = new Eleve("Tom", note);
            eleveRepository.addEleve(nouvelEleve);
            return eleveRepository.findMean("Tom");
        }
        return -1;
	}
}
