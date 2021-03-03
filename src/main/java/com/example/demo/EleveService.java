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
	
	public int said(int note) {
		boolean isNote = isPositiveNote(note) && note <=  20;
		int mean = -1;
		
		if(isNote) {
			Eleve e = new Eleve("Said", note);
			eleveRepository.addEleve(e);
			mean = eleveRepository.findMean("Said");
		}
		
		
		
		return mean;
	}
	
}
