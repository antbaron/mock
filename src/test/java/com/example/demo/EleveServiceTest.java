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
private EleveRepository eleve;
@InjectMocks
private EleveService sut;

@Test
public void Test1() {
    int note = 0;
    Mockito.doNothing().when(eleve).addEleve(Mockito.any());
    Mockito.doReturn(10).when(eleve).findMean(Mockito.anyString());
    int resp = sut.setNote(note);
    Assertions.assertThat(resp).isEqualTo(10);
}


}