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

import static org.mockito.Mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ExamenServiceImplTest {
    @Mock
    ExamenRepositoryImpl repository;

    @Mock
    PreguntaRepositoryImpl preguntaRepository;

    @InjectMocks
    ExamenServiceImpl service;

    @Captor
    ArgumentCaptor<Long> captor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
   //     repository= mock(ExamenRepository.class);
    //    preguntaRepository=mock(PreguntaRepository.class);
    //    service=new ExamenServiceImpl(repository,preguntaRepository);
    }

    @Test
    void findExamenPorNombre() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES);

        Optional<Examen> examen=service.findExamenPorNombre("Matemáticas");


        assertTrue(examen.isPresent());
        assertEquals(5L,examen.orElseThrow().getId());
        assertEquals("Matemáticas",examen.get().getNombre());
    }

    @Test
    void findExamenPorNombreListaVacia() {
        List<Examen> datos= Collections.emptyList();
        when(repository.findAll()).thenReturn(datos);

        Optional<Examen> examen=service.findExamenPorNombre("Matemáticas");
        System.out.println("ver :"+examen);

        assertFalse(examen.isPresent());
    }

    @Test
    void testPreguntasExamen() {
       when(repository.findAll()).thenReturn(Datos.EXAMENES);
       when(preguntaRepository.findPreguntasPorExamenID(anyLong())).thenReturn(Datos.PREGUNTAS);
       Examen examen=service.findExamenPorNombreConPreguntas("Matemáticas");
       assertEquals(5, examen.getPreguntas().size());
       assertTrue(examen.getPreguntas().contains("integrales"));
    }

    @Test
    void testPreguntasExamenVerify() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES);
        when(preguntaRepository.findPreguntasPorExamenID(anyLong())).thenReturn(Datos.PREGUNTAS);
        Examen examen=service.findExamenPorNombreConPreguntas("Matemáticas");
        assertEquals(5, examen.getPreguntas().size());
        assertTrue(examen.getPreguntas().contains("integrales"));
        verify(repository).findAll();
        verify(preguntaRepository).findPreguntasPorExamenID(5L);
    }

    @Test
    void testNoExisteExamenVerify() {
        //Given
        when(repository.findAll()).thenReturn(Collections.emptyList());
        when(preguntaRepository.findPreguntasPorExamenID(anyLong())).thenReturn(Datos.PREGUNTAS);
        //When
        Examen examen=service.findExamenPorNombreConPreguntas("Matemáticas2");
        //Then
        assertNull(examen);
        verify(repository).findAll();
        verify(preguntaRepository).findPreguntasPorExamenID(anyLong());
    }

    @Test
    void testGuardarExamen() {
        //Given
        Examen newExamen=Datos.EXAMEN;
        newExamen.setPreguntas(Datos.PREGUNTAS);

        when(repository.guardar(any(Examen.class))).then(new Answer<Examen>(){

            Long secuencia=8L;
            @Override
            public Examen answer(InvocationOnMock invocation) throws Throwable {
                Examen examen=invocation.getArgument(0);
                examen.setId(secuencia++);
                return examen;
            }
        });
        //When
        Examen examen=service.guardar(newExamen);
        //Examen examen=service.guardar(Datos.EXAMEN);
        //Then
        assertNotNull(examen.getId());
        assertEquals(8L, examen.getId());
        assertEquals("Fisica",examen.getNombre());

        verify(repository).guardar(any(Examen.class));//verifica si el metodo es invocaco
        verify(preguntaRepository).guardarVarias(anyList());
    }

    @Test
    void testManejoException() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES_ID_NULL);
        when(preguntaRepository.findPreguntasPorExamenID(isNull())).thenThrow(IllegalArgumentException.class);

        /*assertThrows(IllegalArgumentException.class,()->{
            service.findExamenPorNombreConPreguntas("Matemáticas");
        });*/

        Exception exception=assertThrows(IllegalArgumentException.class,
                ()->service.findExamenPorNombreConPreguntas("Matemáticas"));

        assertEquals(IllegalArgumentException.class,exception.getClass());
        verify(repository.findAll());
        verify(preguntaRepository).findPreguntasPorExamenID(null);
    }

    @Test
    void testArgumentMatchers() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES);
        when(preguntaRepository.findPreguntasPorExamenID(anyLong())).thenReturn(Datos.PREGUNTAS);

        service.findExamenPorNombreConPreguntas("Matemáticas");

        verify(repository).findAll();
        verify(preguntaRepository).findPreguntasPorExamenID(argThat(arg-> arg!=null && arg.equals(5L)));
        //verify(preguntaRepository).findPreguntasPorExamenID(eq(5L));
    }

    @Test
    void testArgumentMatchers2() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES_ID_NEGATIVOS);
        when(preguntaRepository.findPreguntasPorExamenID(anyLong())).thenReturn(Datos.PREGUNTAS);

        service.findExamenPorNombreConPreguntas("Matemáticas");

        verify(repository).findAll();
        verify(preguntaRepository).findPreguntasPorExamenID(argThat(new MiArgsMatchers()));

    }

    @Test
    void testArgumentMatchers3() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES_ID_NEGATIVOS);
        when(preguntaRepository.findPreguntasPorExamenID(anyLong())).thenReturn(Datos.PREGUNTAS);

        service.findExamenPorNombreConPreguntas("Matemáticas");
        verify(repository).findAll();
        verify(preguntaRepository).findPreguntasPorExamenID(argThat(argument ->
                                         argument!=null && argument>0));

    }

    public static class MiArgsMatchers implements ArgumentMatcher<Long>{

        private Long argument;

        @Override
        public boolean matches(Long argument) {
            this.argument=argument;
            return argument !=null && argument <0;
        }

        @Override
        public String toString() {
            return "es para un mensaje personalizado de eror que imprime mockito en caso de que falle" +
                    "el test "+argument+", debe ser un entero positivo";
        }
    }

    @Test
    void testArgumentCaptor() {

        when(repository.findAll()).thenReturn(Datos.EXAMENES);
        //when(preguntaRepository.findPreguntasPorExamenID(anyLong())).thenReturn(Datos.PREGUNTAS);
        service.findExamenPorNombreConPreguntas("Matemáticas");

        //ArgumentCaptor<Long> captor =ArgumentCaptor.forClass(Long.class);

        verify(preguntaRepository).findPreguntasPorExamenID(captor.capture());

        assertEquals(5L, captor.getValue());
    }

    @Test
    void testDoThrow() {
        Examen examen= Datos.EXAMEN;
        examen.setPreguntas(Datos.PREGUNTAS);
        doThrow(IllegalArgumentException.class).when(preguntaRepository).guardarVarias(anyList());
        assertThrows(IllegalArgumentException.class,()-> service.guardar(examen));
    }

    @Test
    void testDoAnswer() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES);
        //when(preguntaRepository.findPreguntasPorExamenID(anyLong())).thenReturn(Datos.PREGUNTAS);
        doAnswer(invocation -> {
            Long id=invocation.getArgument(0);
            return id==5L?Datos.PREGUNTAS:Collections.emptyList();
        }).when(preguntaRepository).findPreguntasPorExamenID(anyLong());

        Examen examen=service.findExamenPorNombreConPreguntas("Matemáticas");
        assertEquals(5,examen.getPreguntas().size());
        assertTrue(examen.getPreguntas().contains("geometria"));
        assertEquals(5L, examen.getId());
        assertEquals("Matemáticas",examen.getNombre());
    }

    @Test
    void testDoAnswerGuardarExamen() {
        //Given
        Examen newExamen=Datos.EXAMEN;
        newExamen.setPreguntas(Datos.PREGUNTAS);

        doAnswer(new Answer<Examen>(){

            Long secuencia=8L;
            @Override
            public Examen answer(InvocationOnMock invocation) throws Throwable {
                Examen examen=invocation.getArgument(0);
                examen.setId(secuencia++);
                return examen;
            }
        }).when(repository.guardar(any(Examen.class)));

        //When
        Examen examen=service.guardar(newExamen);
        //Examen examen=service.guardar(Datos.EXAMEN);
        //Then
        assertNotNull(examen.getId());
        assertEquals(8L, examen.getId());
        assertEquals("Fisica",examen.getNombre());

        verify(repository).guardar(any(Examen.class));//verifica si el metodo es invocaco
        verify(preguntaRepository).guardarVarias(anyList());
    }

    @Test
    void testDoCallRealMethod() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES);
        //when(preguntaRepository.findPreguntasPorExamenID(anyLong())).thenReturn(Datos.PREGUNTAS);
        doCallRealMethod().when(preguntaRepository).findPreguntasPorExamenID(anyLong());

        Examen examen=service.findExamenPorNombreConPreguntas("Matemáticas");
        assertEquals(5L,examen.getId());
        assertEquals("Matemáticas",examen.getNombre());
    }

    @Test
    void testSpy() {
        ExamenRepository examenRepository=spy(ExamenRepositoryImpl.class);
        PreguntaRepository preguntaRepository=spy(PreguntaRepositoryImpl.class);
        ExamenService examenService=new ExamenServiceImpl(examenRepository,preguntaRepository);

        List<String> preguntas= Arrays.asList("arimetica");
        //when(preguntaRepository.findPreguntasPorExamenID(anyLong())).thenReturn(preguntas);
        doReturn(preguntas).when(preguntaRepository).findPreguntasPorExamenID(anyLong());

        Examen examen=examenService.findExamenPorNombreConPreguntas("Matemáticas");
        assertEquals(5,examen.getId());
        assertEquals("Matemáticas",examen.getNombre());
        assertEquals(5,examen.getPreguntas().size());
        assertTrue(examen.getPreguntas().contains("arimetica"));

        verify(examenRepository).findAll();
        verify(preguntaRepository).findPreguntasPorExamenID(anyLong());
    }

    @Test
    void testOrdenInvocaciones() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES);

        service.findExamenPorNombreConPreguntas("Matemáticas");
        service.findExamenPorNombreConPreguntas("Lenguaje");

        InOrder inOrder = inOrder(preguntaRepository);
        inOrder.verify(preguntaRepository).findPreguntasPorExamenID(6L);
        inOrder.verify(preguntaRepository).findPreguntasPorExamenID(5L);
    }

    @Test
    void testOrdenInvocaciones2() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES);

        service.findExamenPorNombreConPreguntas("Matemáticas");
        service.findExamenPorNombreConPreguntas("Lenguaje");

        InOrder inOrder = inOrder(repository,preguntaRepository);
        inOrder.verify(repository).findAll();
        inOrder.verify(repository).findAll();
        inOrder.verify(preguntaRepository).findPreguntasPorExamenID(6L);
        inOrder.verify(preguntaRepository).findPreguntasPorExamenID(5L);
    }

    @Test
    void testNumeroDeInvocaciones() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES);
        service.findExamenPorNombreConPreguntas("Matemáticas");

        verify(preguntaRepository).findPreguntasPorExamenID(5L);
        verify(preguntaRepository,times(2)).findPreguntasPorExamenID(5L);
        verify(preguntaRepository,atLeast(1)).findPreguntasPorExamenID(5L);
        verify(preguntaRepository,atLeastOnce()).findPreguntasPorExamenID(5L);
        verify(preguntaRepository,atMost(10)).findPreguntasPorExamenID(5L);
        verify(preguntaRepository,atMostOnce()).findPreguntasPorExamenID(5L);
    }

    @Test
    void testNumeroDeInvocaciones2() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES);
        service.findExamenPorNombreConPreguntas("Matemáticas");

        verify(preguntaRepository).findPreguntasPorExamenID(5L);
        verify(preguntaRepository,times(2)).findPreguntasPorExamenID(5L);
        verify(preguntaRepository,atLeast(1)).findPreguntasPorExamenID(5L);
        verify(preguntaRepository,atLeastOnce()).findPreguntasPorExamenID(5L);
        verify(preguntaRepository,atMost(2)).findPreguntasPorExamenID(5L);
        verify(preguntaRepository,atMostOnce()).findPreguntasPorExamenID(5L);
    }

    @Test
    void testNumeroInvocaciones3() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        service.findExamenPorNombreConPreguntas("Matemáticas");

        verify(preguntaRepository,never()).findPreguntasPorExamenID(5L);
        verifyNoInteractions(preguntaRepository);

        verify(repository).findAll();
        verify(repository,times(1)).findAll();
        verify(repository,atLeast(1)).findAll();
        verify(repository,atLeastOnce()).findAll();
        verify(repository,atMost(10)).findAll();
        verify(repository,atMostOnce()).findAll();
    }
}
