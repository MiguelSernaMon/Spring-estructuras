package com.estructuras.app.Backend.service;

import com.estructuras.app.Backend.models.Pregunta;
import com.estructuras.app.Backend.models.Respuesta;
import com.estructuras.app.Backend.repositories.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespuestaServices {
    @Autowired
    RespuestaRepository repository;

    public List<Respuesta> getRespuestasByQuestionId(Long questionId) {
        return repository.findByPregunta_id(questionId);
    }

    public Optional<Respuesta> getRespuestaById(Long respuestaId) {
        return repository.findById(respuestaId);
    }
}
