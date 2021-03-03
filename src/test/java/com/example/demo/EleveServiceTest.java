package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
		int noteok1 = 0;
		int noteok2 = 20;
		int noteok3 = 10;
		int noteneg = -1;
		int noteplus = 21;
		

		Mockito.lenient().doNothing().when(eleveRepository).addEleve(Mockito.any());
		
		Mockito.doReturn(10).when(eleveRepository).findMean("arnaud");
		//Act
		int response = sut.arnaud(noteok1);
		int response2 = sut.arnaud(noteok2);
		int response3 = sut.arnaud(noteok3);
		int response4 = sut.arnaud(noteneg);
		int response5 = sut.arnaud(noteplus);
		//Assert
		Assertions.assertThat(response).isEqualTo(10);
		Assertions.assertThat(response2).isEqualTo(10);
		Assertions.assertThat(response3).isEqualTo(10);
		Assertions.assertThat(response4).isEqualTo(-1);
		Assertions.assertThat(response5).isEqualTo(-1);
	}
}
