package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EleveService {

	@Autowired
	private EleveRepository eleveRepository;
	

	public boolean isPositiveNote(int note) {
		return note <= 0 ;
	}
	
	public int georges(int note) {
		if(!isPositiveNote(note)) {
			return -1;
		}
		this.eleveRepository.addEleve(new Eleve("georges", note));
		return this.eleveRepository.findMean("georges");
	}
	
}
