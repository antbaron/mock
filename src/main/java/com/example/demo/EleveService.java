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
	
	
	public int hugo(int note, Eleve e) {
		int mean = -1;
		if(isPositiveNote(note) && note <= 20) {
			eleveRepository.addEleve(e);
			mean = eleveRepository.findMean("hugo");
			return note;
		}
		return mean;
	}
	
	
}
