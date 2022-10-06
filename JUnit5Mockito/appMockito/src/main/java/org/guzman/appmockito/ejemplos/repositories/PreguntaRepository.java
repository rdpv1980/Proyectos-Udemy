package org.guzman.appmockito.ejemplos.repositories;

import java.util.List;

public interface PreguntaRepository {
    List<String> findPreguntasPorExamenID(Long id);
    void guardarVarias(List<String> preguntas);
}
