package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Eleve;
import com.example.demo.EleveRepository;

@Service
public class EleveService {

	@Autowired
	private EleveRepository eleveRepository;

	public boolean isPositiveNote(int note) {
		return 0 <= note;
	}
	
	public int lauscholzen(int note){
		boolean isNote = this.isPositiveNote(note) && note <= 20;
		int mean = -1;
		if(isNote) {
			Eleve a = new Eleve("Lauriane", 1);
			eleveRepository.addEleve(a);
			mean = eleveRepository.findMean("Lauriane");
		}
		
        return mean;
       
    }
	
	
}
