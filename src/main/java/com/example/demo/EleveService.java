package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EleveService {

	@Autowired
	private EleveRepository eleveRepository;
	

	public boolean isPositiveNote(int note) {
		return 0 < note ;
	}
	
	public int corentin(int note) {
		if(!isPositiveNote(note) || note>20) return -1;
		eleveRepository.addEleve(new Eleve("Roques",note));
		return  note;
	}
	
}
