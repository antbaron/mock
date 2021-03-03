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
		
		if(isPositiveNote(note)) {
			Eleve eleve = new Eleve("Lucie",note);
			this.eleveRepository.addEleve(eleve);
			return this.eleveRepository.findMean("Lucie");
		}
		return -1;
	}

	public EleveRepository getEleveRepository() {
		return eleveRepository;
	}

	public void setEleveRepository(EleveRepository eleveRepository) {
		this.eleveRepository = eleveRepository;
	}
	
}
