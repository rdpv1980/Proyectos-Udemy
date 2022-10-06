package org.guzman.appmockito.ejemplos.repositories;

import org.guzman.appmockito.ejemplos.models.Examen;

import java.util.List;

public interface ExamenRepository {

    Examen guardar(Examen examen);

    List<Examen> findAll();
}
