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
	
	public int aleledain(int num) {
		int mean = -1;
		if(isPositiveNote(num) && num <= 20) {
			eleveRepository.addEleve(new Eleve("alex", num));
			mean = eleveRepository.findMean("alex");		
		}
		return mean;
	}
	
	
}
