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
		
		//Arrange
		int note = 0;
		int expected = 10;
		
		ArgumentCaptor<Eleve> acEleve = ArgumentCaptor.forClass(Eleve.class);
		Mockito.doNothing().when(eleveRepository).addEleve(acEleve.capture());
		Mockito.doReturn(10).when(eleveRepository).findMean("alex");
		//Act
		int response = sut.aleledain(note);
		
		//Assert
		Assertions.assertThat(response).isEqualTo(expected);
		
		Eleve e = acEleve.getValue();
		Assertions.assertThat(e.getName()).isEqualTo("alex");
		Assertions.assertThat(e.getNote()).isEqualTo(note);
		
		Mockito.verify(eleveRepository, Mockito.times(1)).addEleve(e);
	}
	
	@Test
	void maxNoteTest() {
		int note = 20;
		int expected = 10;
		
		Mockito.doReturn(true).when(sut).isPositiveNote(note);
		Mockito.doReturn(expected).when(eleveRepository).findMean("alex");
		
		int reponse = sut.aleledain(note);
		
		Assertions.assertThat(reponse).isEqualTo(expected);
	}
	
	@Test
	void invalidTest() {
		int note = 648;
		int expected = -1;
		
		Mockito.doReturn(true).when(sut).isPositiveNote(note);
		
		int reponse = sut.aleledain(note);
		
		Assertions.assertThat(reponse).isEqualTo(expected);
	}
	
}
