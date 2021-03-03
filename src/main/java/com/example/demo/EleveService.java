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
	
	public int enzo(int note) {
		int mean = -1;
		if(isPositiveNote(note) && note <= 20) {
			Eleve enzo = new Eleve("Enzo", note);
			eleveRepository.addEleve(enzo);
			mean = eleveRepository.findMean("Enzo");
		}
		return mean;
	}
	
}
