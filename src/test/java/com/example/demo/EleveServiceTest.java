package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EleveServiceTest {

    @Mock
    private EleveRepository eleveRepository;

    @Spy
    @InjectMocks
    private EleveService sut;

    @Test public void testisPositiveNote(){
        boolean response = sut.isPositiveNote(0);

        Assertions.assertThat(response).isTrue();
    }

    @Test
    public void test1(){
        int note = 0;

        Mockito.doReturn(true).when(sut).isPositiveNote(note);

        ArgumentCaptor<Eleve> acEleve = ArgumentCaptor.forClass(Eleve.class);
        Mockito.lenient().doNothing().when(eleveRepository).addEleve(acEleve.capture());

        Mockito.doReturn(10).when(eleveRepository).findMean("sean");

        int response = sut.sean(note);

        Assertions.assertThat(response).isEqualTo(10);

        Eleve photo = acEleve.getValue();
        Assertions.assertThat(photo.getName()).isEqualTo("sean");
        Assertions.assertThat(photo.getNote()).isEqualTo(note);
        Mockito.verify(eleveRepository, Mockito.times(1)).addEleve(Mockito.any());
//        Mockito.verify(eleveRepository, Mockito.never()).addEleve(Mockito.any());
    }
	
}
