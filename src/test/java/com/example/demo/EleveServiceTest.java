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
	void testIsPositiveNoteTrue() {
		Assertions.assertThat(sut.isPositiveNote(0)).isTrue();
	}
	
	@Test
	void testIsPositiveNoteFalse() {
		Assertions.assertThat(sut.isPositiveNote(-1)).isFalse();
	}
	
	@Test
	void testFonction() {
		// Arrange
		int note = 0;
		int expected = 10;
		
		ArgumentCaptor<Eleve> acEleve = ArgumentCaptor.forClass(Eleve.class);
		
		Mockito.doNothing().when(eleveRepository).addEleve(acEleve.capture());
		Mockito.doReturn(expected).when(eleveRepository).findMean("Emirkan");
		
		Mockito.doReturn(true).when(sut).isPositiveNote(note);
		
		// Act
		int reponse = sut.emirCakir(note);
		
		// Assert
		Assertions.assertThat(reponse).isEqualTo(expected);
		
		Assertions.assertThat(acEleve.getValue().getNote()).isEqualTo(note);
		Assertions.assertThat(acEleve.getValue().getName()).isEqualTo("Emirkan");
		Mockito.verify(eleveRepository).addEleve(acEleve.getValue());
	}
	
	@Test
	void testFonctionNoteMax() {
		int note = 20;
		int expected = 10;
		
		Mockito.doReturn(true).when(sut).isPositiveNote(note);
		Mockito.doReturn(expected).when(eleveRepository).findMean("Emirkan");
		
		int reponse = sut.emirCakir(note);
		
		Assertions.assertThat(reponse).isEqualTo(expected);
	}
	
	@Test
	void testFonctionNoteInvalide() {
		int note = 666;
		int expected = -1;
		
		Mockito.doReturn(true).when(sut).isPositiveNote(note);
		
		int reponse = sut.emirCakir(note);
		
		Assertions.assertThat(reponse).isEqualTo(expected);
	}
	
}