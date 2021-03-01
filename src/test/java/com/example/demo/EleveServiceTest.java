package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EleveServiceTest {
	
	@Mock
	private EleveRepository eleveRepository;
	
	@InjectMocks
	private EleveService sut;
	
	@Test
	public void test1() {
		// Arrange
		int note = 1;
		int expected = 10;
		
		ArgumentCaptor<Eleve> acEleve = ArgumentCaptor.forClass(Eleve.class);
		
		Mockito.doNothing().when(eleveRepository).addEleve(acEleve.capture());
		Mockito.doReturn(expected).when(eleveRepository).findMean("Lauriane");
		
		//Mockito.doReturn(true).when(sut).isPositiveNote(note);
		
		// Act
		int response = sut.lauscholzen(note);
		
		// Assert
		Assertions.assertThat(response).isEqualTo(expected);
		
		Eleve e = acEleve.getValue();
		Assertions.assertThat(e.getName()).isEqualTo("Lauriane");
		Assertions.assertThat(e.getNote()).isEqualTo(note);
		
		Mockito.verify(eleveRepository, Mockito.times(1)).addEleve(e);
		
		
		
	}
	
}
