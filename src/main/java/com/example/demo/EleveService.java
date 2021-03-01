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
	
	public int fonctionTest(int Note) {
		if (!isPositiveNote(Note) || Note > 20){
			return -1;
		}
		String name = "Emirkan CAKIR";
		eleveRepository.addEleve(new Eleve(name, Note));
		return eleveRepository.findMean(name);
	}
	
	
}
