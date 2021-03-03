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

	public int victor(int note) {
        boolean isNote = this.isPositiveNote(note) && note <=20;
        int mean =  -1;
        if(isNote) {
            Eleve a = new Eleve("victor", note);
            eleveRepository.addEleve(a);
            mean = eleveRepository.findMean("victor");
        }
        return mean;
    }    
	
	
}
