package com.example.demo;

import org.assertj.core.api.Assertions;
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
	public void testisPositiveNote() {
		boolean response = sut.isPositiveNote(0);
		
		Assertions.assertThat(response).isTrue();
	}
	
	
	@Test
	public void test1() {
		//Arrange
		int note =0;
		
		
		
		
		ArgumentCaptor<Eleve> acEleve = ArgumentCaptor.forClass(Eleve.class);
		//Mockito.doNothing().when(eleveRepository).addEleve(Mockito.any());
		Mockito.doReturn(10).when(eleveRepository).findMean("jeffrey");
		Mockito.lenient().doNothing().when(eleveRepository).addEleve(acEleve.capture());
		// Act
		int response = sut.jeffrey(note);
		//Assert
		Assertions.assertThat(response).isEqualTo(10);
		Mockito.verify(eleveRepository,Mockito.times(1)).addEleve(Mockito.any());
		Eleve photo = acEleve.getValue();
		
		Assertions.assertThat(photo.getName()).isEqualTo("jeffrey");
		Assertions.assertThat(photo.getNote()).isEqualTo(note);
		//Mockito.verify(eleveRepository,Mockito.never().addeleve())
	}
}
