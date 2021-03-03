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

	public int dorian(int note) {
		if (isPositiveNote(note) && note <= 20){
			Eleve e = new Eleve("Dorian", note);
			eleveRepository.addEleve(e);
			return eleveRepository.findMean(e.getName());
		}
		return -1;
	}
	
}
