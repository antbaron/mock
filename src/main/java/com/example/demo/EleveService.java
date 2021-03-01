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
	
	public boolean isANote(int note){
		return note <= 20;
	}
	
	public int dalhenni(int note) {
		if(isPositiveNote(note) && isANote(note)) {
			Eleve eleve = new Eleve("Dalila", 12);
			eleveRepository.addEleve(eleve);
			return eleveRepository.findMean("Dalila");
		}
		
		return -1;
	}
	
}
