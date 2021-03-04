package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EleveService {

	@Autowired
	private EleveRepository eleveRepository;
	

	public boolean isPositiveNote(int note) {
		return 0 <= note && note <= 20;
	}
	
	public int anthony(int note) {
		boolean isNote = this.isPositiveNote(note);
		int mean = -1;
		if(isNote) {
			Eleve a = new Eleve("anthony", note);
			eleveRepository.addEleve(a);
			mean = eleveRepository.findMean("anthony");
		} 

		return mean;
	}
}
