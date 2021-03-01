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
	
	public int sebuc4(int note) {
		
		// verifier que c'est une note
		if(note < 0 || note > 20) {
			// return -1 si incorrect
			return -1;
		} else {
			// sinon créer un élève Seb
			String name = "seb";
			Eleve seb = new Eleve(name, note);
			// appeller add eleve de eleve repository
			eleveRepository.addEleve(seb);
			
			// retourner l'entier resulat de la methode findmean
			return eleveRepository.findMean(name);
			
		}
		
	}
	
	
}
