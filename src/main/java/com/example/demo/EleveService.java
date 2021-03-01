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
	
	public int aleledain(int num) {

		if(isPositiveNote(num)) {
			eleveRepository.addEleve(new Eleve("Alex", num));
			eleveRepository.findMean("Alex");		
		}
		return -1;
	}
	
	
}
