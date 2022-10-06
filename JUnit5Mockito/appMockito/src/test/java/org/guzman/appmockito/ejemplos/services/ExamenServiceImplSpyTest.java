package org.guzman.appmockito.ejemplos.services;

import org.guzman.appmockito.ejemplos.Datos;
import org.guzman.appmockito.ejemplos.models.Examen;
import org.guzman.appmockito.ejemplos.repositories.ExamenRepository;
import org.guzman.appmockito.ejemplos.repositories.ExamenRepositoryImpl;
import org.guzman.appmockito.ejemplos.repositories.PreguntaRepository;
import org.guzman.appmockito.ejemplos.repositories.PreguntaRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExamenServiceImplSpyTest {

    @Spy
    ExamenRepositoryImpl repository;

    @Spy
    PreguntaRepositoryImpl preguntaRepository;

    @InjectMocks
    ExamenServiceImpl service;

    @Test
    void testSpy() {
                List<String> preguntas= Arrays.asList("arimetica");
        //when(preguntaRepository.findPreguntasPorExamenID(anyLong())).thenReturn(preguntas);
        doReturn(preguntas).when(preguntaRepository).findPreguntasPorExamenID(anyLong());

        Examen examen=service.findExamenPorNombreConPreguntas("Matemáticas");
        assertEquals(5,examen.getId());
        assertEquals("Matemáticas",examen.getNombre());
        assertEquals(5,examen.getPreguntas().size());
        assertTrue(examen.getPreguntas().contains("arimetica"));

        verify(repository).findAll();
        verify(preguntaRepository).findPreguntasPorExamenID(anyLong());
    }
}
