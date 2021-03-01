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


    @Test
    void testIsPositiveNote() {
        Assertions.assertThat(sut.isPositiveNote(0)).isTrue();
    }
    @Test
    void testIsNotPositiveNote() {
        Assertions.assertThat(sut.isPositiveNote(-1)).isFalse();
    }
    @Test
    public void test1(){
        int note = 0;
        int expected = 10;

//        Eleve a =new Eleve("f",note);
        ArgumentCaptor<Eleve> acEleve = ArgumentCaptor.forClass(Eleve.class);

        Mockito.doNothing().when(eleveRepository).addEleve(acEleve.capture());
        Mockito.doReturn(expected).when(eleveRepository).findMean("f");

        Mockito.doReturn(true).when(sut).isPositiveNote(note);


        int response = sut.flolemaire(note);

        Assertions.assertThat(response).isEqualTo(expected);

        Assertions.assertThat(acEleve.getValue().getNote()).isEqualTo(note);
        Assertions.assertThat(acEleve.getValue().getName()).isEqualTo("f");
        Mockito.verify(eleveRepository).addEleve(acEleve.getValue());

    }

    @Test
    void testMaFonctionNote() {
        int note = 20;
        int expected = 10;
        Mockito.doReturn(true).when(sut).isPositiveNote(note);
        Mockito.doReturn(expected).when(eleveRepository).findMean("f");
        int reponse = sut.flolemaire(note);

        Assertions.assertThat(reponse).isEqualTo(expected);
    }

    @Test
    void testMaFonctionFausseNote() {
        int note = 21;
        int expected = -1;

        Mockito.doReturn(true).when(sut).isPositiveNote(note);

        int reponse = sut.flolemaire(note);

        Assertions.assertThat(reponse).isEqualTo(expected);
    }
}
