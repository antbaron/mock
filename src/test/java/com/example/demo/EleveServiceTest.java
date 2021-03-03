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
	
	@Test void testisPositiveNote() {
		boolean response = sut.isPositiveNote(0);
		Assertions.assertThat(response).isTrue();
	}
	
	@Test
	public void test1() {
		int note = 0;
		ArgumentCaptor<Eleve> acEleve = ArgumentCaptor.forClass(Eleve.class);
		Mockito.lenient().doNothing().when(eleveRepository).addEleve(acEleve.capture());
		
		Mockito.doReturn(10).when(eleveRepository).findMean(Mockito.anyString());
		int response = sut.amandine(note);
		Assertions.assertThat(response).isEqualTo(10);
		
		Eleve photo = acEleve.getValue();
		Assertions.assertThat(photo.getName()).isEqualTo("Amandine");
		Assertions.assertThat(photo.getNote()).isEqualTo(note);
		
		Mockito.verify(eleveRepository, Mockito.times(1)).addEleve(Mockito.any());
	}
}
