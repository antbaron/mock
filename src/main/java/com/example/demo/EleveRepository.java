 package com.example.demo;

import org.springframework.stereotype.Repository;

import com.example.demo.Eleve;

@Repository
public interface EleveRepository {

	public void addEleve(Eleve eleve);
	
	public int findMean(String name);
}
