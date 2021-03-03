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

	public int theo(int note) {
		boolean isValid = isPositiveNote(note) && note <= 20;
		int mean = -1;
		if (isValid){
			Eleve eleve = new Eleve("theo", note);
			eleveRepository.addEleve(eleve);
			mean = eleveRepository.findMean("theo");;
		}
		return mean;
	}
	
	
}
