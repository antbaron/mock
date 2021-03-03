package com.example.demo;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

public class EleveServiceTest {

	@Mock
	private EleveRepository eleveRepository;
	
	@InjectMocks
	private EleveService sut;
}
