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


	 public int mobouhou(int note) {
		if(isPositiveNote(note) && note<=20){
			Eleve eleve = new Eleve("mostafa",note);
			eleveRepository.addEleve(eleve);
			note = eleveRepository.findMean("mostafa");
		}else{
			note =  -1;
		}
		return note;
	}
	
}
