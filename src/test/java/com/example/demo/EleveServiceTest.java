package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

public class EleveServiceTest {
	
	@Mock
	private EleveRepository eleveRepository;
	
	@InjectMocks
	private EleveService sut;
	
	
	@Test
	public void test1() {
		// Arrange
		int note = 0;
		
		ArgumentCaptor<Eleve> acEleve = ArgumentCaptor.forClass(Eleve.class);
		Mockito.doNothing().when(eleveRepository).addEleve(acEleve.capture());
		
		Mockito.doReturn(10).when(eleveRepository).findMean("Said");
		
		//Act
		int response = sut.said(note);
		
		// Assert
		Eleve photo = acEleve.getValue();
		Assertions.assertThat(photo.getName()).isEqualTo("Said");
		Assertions.assertThat(photo.getNote()).isEqualTo(note);
		
		Assertions.assertThat(response).isEqualTo(10);
	}
	
}
