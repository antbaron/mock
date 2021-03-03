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
	public void testIsPositiveNote() {
		boolean res = sut.isPositiveNote(0);
		
		Assertions.assertThat(res).isTrue();
	}
	
	@Test
	public void test1() {
		// Arrange
		int note = 0;
		ArgumentCaptor<Eleve> acEleve = ArgumentCaptor.forClass(Eleve.class);
		Mockito.doNothing().when(eleveRepository).addEleve(acEleve.capture());
		Mockito.doReturn(10).when(eleveRepository).findMean("bob");
		Mockito.doReturn(true).when(sut).isPositiveNote(note);
		
		// Act
		int res = sut.nprz(note);
		
		// Assert
		Eleve photo = acEleve.getValue();
		Assertions.assertThat(photo.getName()).isEqualTo("bob");
		Assertions.assertThat(photo.getNote()).isEqualTo(note);
		Assertions.assertThat(res).isEqualTo(10);
	}
}
