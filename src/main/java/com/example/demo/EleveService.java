package com.example.demo;

import com.example.demo.EleveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EleveService {

	@Autowired
	private EleveRepository eleveRepository;
	

	public boolean isPositiveNote(int note) {
		return 0 < note;
	}
	
	public int claire(int note) {
		if(!isPositiveNote(note)) {
			return -1;
		}else {
			int result = 0;
			Eleve claire = new Eleve("Claire", note);
			eleveRepository.addEleve(claire);
			result = eleveRepository.findMean("Claire");
		
			return result;
		}
		
	}
	
	
}
