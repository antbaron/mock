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
	
	public int nprz(int note) {
		
		int result = -1;
		
		if(isPositiveNote(note) && note < 20) {
			Eleve eleve = new Eleve("bob", note);
			eleveRepository.addEleve(eleve);
			
			result = eleveRepository.findMean("bob");
			
		}
		return result;
	}
	
}
