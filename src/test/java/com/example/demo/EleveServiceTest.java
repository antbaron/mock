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
    void testIsPositiveNoteFalse() {
        Assertions.assertThat(sut.isPositiveNote(-1)).isFalse();
    }

    @Test
    public void testTibborelNoteValide() {
        // Arrange
        int note = 0;
        int expected = 10;
        ArgumentCaptor<Eleve> eleve = ArgumentCaptor.forClass(Eleve.class);

        String name = "Tibère Borel";

        Mockito.doNothing().when(eleveRepository).addEleve(eleve.capture());
        Mockito.doReturn(10).when(eleveRepository).findMean(name);

        Mockito.doReturn(true).when(sut).isPositiveNote(note);

        // Act
        int ret = sut.tibborel(note);

        // Assert
        Assertions.assertThat(ret).isEqualTo(expected);

        Eleve a = eleve.getValue();
        Assertions.assertThat(a.getName()).isEqualTo(name);
        Assertions.assertThat(a.getNote()).isEqualTo(note);

        Mockito.verify(eleveRepository, Mockito.times(1)).addEleve(a);
    }

    @Test
    public void testTibborelNoteInferieurZero() {
        // Arrange
        int note = -10;
        int expected = -1;

        Mockito.doReturn(false).when(sut).isPositiveNote(note);

        // Act
        int ret = sut.tibborel(note);

        // Assert
        Assertions.assertThat(ret).isEqualTo(expected);
    }

    @Test
    public void testTibborelNoteSuperieur() {
        // Arrange
        int note = 21;
        int expected = -1;

        Mockito.doReturn(true).when(sut).isPositiveNote(note);

        // Act
        int ret = sut.tibborel(note);

        // Assert
        Assertions.assertThat(ret).isEqualTo(expected);
    }

    @Test
    public void testTibborelNoteMax() {
        // Arrange
        int note = 20;
        int expected = 10;
        ArgumentCaptor<Eleve> eleve = ArgumentCaptor.forClass(Eleve.class);

        String name = "Tibère Borel";

        Mockito.doNothing().when(eleveRepository).addEleve(eleve.capture());
        Mockito.doReturn(10).when(eleveRepository).findMean(name);

        Mockito.doReturn(true).when(sut).isPositiveNote(note);

        // Act
        int ret = sut.tibborel(note);

        // Assert
        Assertions.assertThat(ret).isEqualTo(expected);

        Eleve a = eleve.getValue();
        Assertions.assertThat(a.getName()).isEqualTo(name);
        Assertions.assertThat(a.getNote()).isEqualTo(note);

        Mockito.verify(eleveRepository, Mockito.times(1)).addEleve(a);
    }
}
