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
	
	public int mathieu(int note) {
		if (note < 0 || note > 20) {
			return -1;
		}
		Eleve eleve = new Eleve("Mathieu", note)
		eleveRepository.addEleve(eleve);
		return eleveRepository.findMean(nom);
	}
}
