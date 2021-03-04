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
	public void testisPositiveNote() {
		boolean response = sut.isPositiveNote(0);

		Assertions.assertThat(response).isTrue();
	}

	@Test
	public void test1() {
		// Arrange
		int note = 0;

		Mockito.doReturn(true).when(sut).isPositiveNote(note);

		ArgumentCaptor<Eleve> acEleve = ArgumentCaptor.forClass(Eleve.class);
		Mockito.lenient().doNothing().when(eleveRepository).addEleve(acEleve.capture());

		Mockito.doReturn(10).when(eleveRepository).findMean("anthony");
		// Act
		int response = sut.anthony(note);
		// Assert
		Assertions.assertThat(response).isEqualTo(10);

		Eleve photo = acEleve.getValue();
		Assertions.assertThat(photo.getName()).isEqualTo("anthony");
		Assertions.assertThat(photo.getNote()).isEqualTo(note);

		Mockito.verify(eleveRepository, Mockito.times(1)).addEleve(Mockito.any());
	}
}
