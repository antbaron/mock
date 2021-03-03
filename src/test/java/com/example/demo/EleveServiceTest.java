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
class EleveServiceTest {

	@Mock
	private EleveRepository eleveRepository;
	
	@Spy
	@InjectMocks
	private EleveService sut;
	
	@Test
	void test1() {
		// Arrange
		int note = 0;
		ArgumentCaptor<Eleve> acEleve = ArgumentCaptor.forClass(Eleve.class);
		Mockito.doNothing().when(eleveRepository).addEleve(acEleve.capture());
		Mockito.doReturn(10).when(eleveRepository).findMean("georges");
		
		// Act
		int response = sut.georges(note);
		Eleve photo = acEleve.getValue();
		
		// Assert
		Assertions.assertThat(response).isEqualTo(10);
		Assertions.assertThat(sut.isPositiveNote(note)).isTrue();
		Assertions.assertThat(photo.getName()).isEqualTo("georges");
		Assertions.assertThat(photo.getNote()).isEqualTo(note);
		
	}
	
	
}
