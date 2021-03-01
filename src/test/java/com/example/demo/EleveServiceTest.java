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
	
	
	@Test
	public void isPositive() {
		boolean response = sut.isPositiveNote(0);
		Assertions.assertThat(response).isTrue();
	}
	
	@Test
	public void test1() {
		// Arrange
		int note = 0;
		int expected = 10;
		
		ArgumentCaptor<Eleve> acEleve = ArgumentCaptor.forClass(Eleve.class);
		
		Mockito.doNothing().when(eleveRepository).addEleve(acEleve.capture());
		Mockito.doReturn(expected).when(eleveRepository).findMean("anthony");
		
		Mockito.doReturn(true).when(sut).isPositiveNote(note);
		// Act
		int response = sut.antbaron(note);
		// Assert
		Assertions.assertThat(response).isEqualTo(expected);
		
		Eleve e = acEleve.getValue();
		Assertions.assertThat(e.getName()).isEqualTo("anthony");
		Assertions.assertThat(e.getNote()).isEqualTo(note);

		Mockito.verify(eleveRepository, Mockito.times(1)).addEleve(e);
		
	}
}


