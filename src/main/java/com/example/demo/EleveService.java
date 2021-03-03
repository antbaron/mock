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
	
	public int florent(int note) {
		if(isPositiveNote(note) && note <= 20) {
			String name = "florent";
			Eleve eleve = new Eleve(name, note);
			eleveRepository.addEleve(eleve);
			return eleveRepository.findMean(name);
		}
		return -1;
	}
	
	
}
