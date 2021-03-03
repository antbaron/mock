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
	
	public int arnaud(int note) {
		if(note > 20 || note < 0) {
			return -1;
		}else {
			Eleve arnaud = new Eleve("arnaud", note);
			//eleveRepository.addEleve(arnaud);
			return eleveRepository.findMean("arnaud");
		}

	}
	
}
