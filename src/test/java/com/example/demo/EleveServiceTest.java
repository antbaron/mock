package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EleveServiceTest {
  @Mock
  private EleveRepository eleveRepository;

  @Mock
  private EleveService sut;

  @Test
  public void test1() {
    int note = 0;
    ArgumentCaptor<Eleve> acEleve = ArgumentCaptor.forClass(Eleve.class);
    Mockito.doNothing().when(eleveRepository).addEleve(acEleve.capture());
    Mockito.doReturn(10).when(eleveRepository).findMean("theo");

    int response = sut.theo(note);

    Eleve photo = acEleve.getValue();
    Assertions.assertThat(photo.getName()).isEqualTo("theo");
    Assertions.assertThat(photo.getNote()).isEqualTo(10);
    Assertions.assertThat(response).isEqualTo(10);

  }

  public void test2() {
    int note = -4;

    int response = sut.theo(note);

    Assertions.assertThat(response).isEqualTo(-1);
  }

  public void test3() {
    int note = 24;

    int response = sut.theo(note);

    Assertions.assertThat(response).isEqualTo(-1);
  }
	
}
