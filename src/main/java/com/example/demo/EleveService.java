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
	
	public int chris(int note) {
		boolean isNote = this.isPositiveNote(note) && note <=20;
		int mean = -1;
		if (isNote){
			Eleve nouvel_eleve = new Eleve(null, note);
			eleveRepository.addEleve(nouvel_eleve);
			mean = eleveRepository.findMean("chris");
		}
		return mean;
	}
	
}
