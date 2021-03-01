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

	public int flolemaire(int note){
		if(note < 0 || note > 20){
			return -1;
		}
		eleveRepository.addEleve(new Eleve("f",15));
		return eleveRepository.findMean("f");

	};
	
}
