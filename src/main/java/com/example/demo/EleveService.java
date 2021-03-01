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
	
	public int stajesoph(int note) {
		if(this.isPositiveNote(note) && note <= 20) {
			eleveRepository.addEleve(new Eleve("stanley",note));
			return eleveRepository.findMean("stanley");
		}
		return -1;
	}
}
