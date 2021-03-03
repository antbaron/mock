package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;


@ExtendWith(MockitoExtension.class)
public class EleveServiceTest {

	@Mock
	private EleveRepository eleveRepository;
	
	@Spy
	@InjectMocks
	private EleveService sut;
	
	@Test
	public void testIsPositiveNote() {
		boolean response = sut.isPositiveNote(0);
		Assertions.assertThat(response).isTrue();
	}
	
	@Test
	public void test1() {
		// Arrange
		int note = 0;
		ArgumentCaptor<Eleve> acEleve = ArgumentCaptor.forClass(Eleve.class);
		Mockito.doNothing().when(eleveRepository).addEleve(acEleve.capture());
		Mockito.doReturn(10).when(eleveRepository).findMean("Lucie");
		// Act 
		int response = sut.lucie(note);
		
		// Assert
		Eleve photo = acEleve.getValue();
		
		Assertions.assertThat(photo.getName()).isEqualTo("Lucie");
		Assertions.assertThat(photo.getNote()).isEqualTo(note);
		
		Assertions.assertThat(response).isEqualTo(10);
	}
}
