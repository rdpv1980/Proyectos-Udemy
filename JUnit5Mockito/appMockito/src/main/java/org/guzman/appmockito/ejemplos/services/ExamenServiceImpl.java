package org.guzman.appmockito.ejemplos.services;

import org.guzman.appmockito.ejemplos.models.Examen;
import org.guzman.appmockito.ejemplos.repositories.ExamenRepository;
import org.guzman.appmockito.ejemplos.repositories.PreguntaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class ExamenServiceImpl implements ExamenService{

    private ExamenRepository examenRepository;
    private PreguntaRepository preguntaRepository;

    public ExamenServiceImpl(ExamenRepository examenRepository,PreguntaRepository preguntaRepository) {

        this.examenRepository = examenRepository;
        this.preguntaRepository=preguntaRepository;
    }

    /*@Override
    public Examen findExamenPorNombre(String nombre) {
        Optional<Examen> examenOptional=examenRepository.findAll()
                .stream()
                .filter(e -> e.getNombre().contains(nombre))
                .findFirst();
        Examen examen=null;
        if (examenOptional.isPresent()){
            examen=examenOptional.orElseThrow();
        }

        return examen;
    }*/

    @Override
    public Optional<Examen> findExamenPorNombre(String nombre) {
        return examenRepository.findAll()
                                   .stream()
                                   .filter(e -> e.getNombre().contains(nombre))
                                   .findFirst();
    }

    @Override
    public Examen findExamenPorNombreConPreguntas(String nombre) {
        Optional<Examen> examenOptional=findExamenPorNombre(nombre);
        Examen examen=null;
        if (examenOptional.isPresent()){
            examen=examenOptional.orElseThrow();
            List<String> preguntas=preguntaRepository.findPreguntasPorExamenID(examen.getId());
            preguntaRepository.findPreguntasPorExamenID(examen.getId());
            examen.setPreguntas(preguntas);
        }
        return examen;
    }

    @Override
    public Examen guardar(Examen examen) {

        if (!examen.getPreguntas().isEmpty()){
            preguntaRepository.guardarVarias(examen.getPreguntas());
        }
        return examenRepository.guardar(examen);
    }
}
