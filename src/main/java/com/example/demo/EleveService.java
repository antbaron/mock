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
	
	public int alemor(int note) {
		if ( isPositiveNote(note) ) {
			Eleve eleve = new Eleve("Alemor", note);
			eleveRepository.addEleve(eleve);
			return eleveRepository.findMean("Alemor");
		} else {
			return -1;
		}
		
	}
	
	
}
