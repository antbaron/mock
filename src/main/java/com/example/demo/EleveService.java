package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.EleveRepository;

@Service
public class EleveService {

	@Autowired
	private EleveRepository eleveRepository;
	

	public boolean isPositiveNote(int note) {
		return 0 <= note;
	}
	
	//A comment
	public int setNote(int note) {
		if(isPositiveNote(note)) {
			return note;
		}else {
			return 0;
		}
	}
}
