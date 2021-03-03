package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EleveServiceTest {

	@Mock
	private EleveRepository eleveRepository;
	
	@Spy
	@InjectMocks
	private EleveService sut;
	
	@Test
	public void test1() {
		// Arrange
		int note = 0;
		
		ArgumentCaptor<Eleve> acE = ArgumentCaptor.forClass(Eleve.class);
		
		Mockito.doReturn(true).when(sut).isPositiveNote(note);
		
		Mockito.doNothing().when(eleveRepository).addEleve(acE.capture());
		
		Mockito.doReturn(10).when(eleveRepository).findMean("romain");
		// Act
		int response = sut.romain(note);
		
		// Assert
		Eleve capture = acE.getValue();
		Assertions.assertEquals("romain", capture.getName());
		Assertions.assertEquals(note, capture.getNote());
		
		Assertions.assertEquals(10, response);
		
	}
}
