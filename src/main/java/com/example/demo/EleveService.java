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
	
	// 1/ ajouter un entier en param appelé note
	// 2/ Vérifier que cet entier est bien une note 
	// 3/ /Si la note n'est pas correcte -> return -1
	// 3.bis // si la note est correcte -6> créer un éléève + appelé la métthode addEleève du repo.
	// 4/ retourner l'entier , qui est le résultat de la function findMean
	public int tcapriolombardi(int note) {
		if(isPositiveNote(note)) {
			Eleve e = new Eleve("Thomas", note);
			eleveRepository.addEleve(e);
			return eleveRepository.findMean("Thomas");
		}
		else {
			return -1;
		}
	}
	

}
