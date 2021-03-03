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
	
	public int romain(int note) {
		if (!isPositiveNote(note) || note > 20) {
			return -1;
		}
		
		Eleve e = new Eleve("romain", note);
		eleveRepository.addEleve(e);

		return eleveRepository.findMean("romain");
	}
	
	
}
