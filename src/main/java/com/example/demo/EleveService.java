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
	
	public int lucleroux(int note) {
		if(isPositiveNote(note) && note <= 20) {
			Eleve newEleve = new Eleve("Lucas Leroux", note);
			eleveRepository.addEleve(newEleve);
			return eleveRepository.findMean("Lucas Leroux");
		}
		else {
			return -1;
		}
	}
	
}
