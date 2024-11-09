package com.estructuras.app.Backend.service;

import com.estructuras.app.Backend.models.Pregunta;
import com.estructuras.app.Backend.repositories.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreguntaServices {
    @Autowired
    private PreguntaRepository repository;

    public List<Pregunta> getPreguntasByLessonId(Long lessonId) {
        return repository.findByLeccion_id(lessonId);
    }
}
