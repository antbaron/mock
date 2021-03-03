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
	
	public int lucie(int note) {
		
		
		int mean = -1;
		if(isPositiveNote(note) && note <= 20) {
			Eleve eleve = new Eleve("Lucie",note);
			this.eleveRepository.addEleve(eleve);
			mean = this.eleveRepository.findMean("Lucie");
		}
		return mean;
	}

	public EleveRepository getEleveRepository() {
		return eleveRepository;
	}

	public void setEleveRepository(EleveRepository eleveRepository) {
		this.eleveRepository = eleveRepository;
	}
	
}
