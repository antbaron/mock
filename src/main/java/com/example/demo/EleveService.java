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
	
	public int thomas(int note) {
		
		if (note > 20 || !isPositiveNote(note)) {
			return -1;
		}
		
		Eleve eleve = new Eleve("Thomas", note);
				
		eleveRepository.addEleve(eleve);
		
		int mean = eleveRepository.findMean(eleve.getName());
		
		return mean;
		
	}
	
}
