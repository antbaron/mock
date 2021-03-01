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
	
	public int dorsonzogni(int note) 
	{
		if(isPositiveNote(note) && note < 21) 
		{
			Eleve jc = new Eleve("eleveName", note);
			eleveRepository.addEleve(jc);
			return eleveRepository.findMean(jc.getName());
		}
		else return -1;
	}
	
}
