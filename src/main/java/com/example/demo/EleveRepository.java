package com.example.demo;

import org.springframework.stereotype.Repository;

@Repository
public interface EleveRepository {

	public void addEleve(Eleve eleve);
	
	public int findMean(String name);

}
