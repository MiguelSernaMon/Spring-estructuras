package com.estructuras.app.Backend.service;

import com.estructuras.app.Backend.models.Contenido;
import com.estructuras.app.Backend.repositories.ContenidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContenidoServices {
    @Autowired
    private ContenidoRepository repository;

    public List<Contenido> getContentByLessonId(Long leccionId){
        return repository.findByLeccion_id(leccionId);
    }
}
