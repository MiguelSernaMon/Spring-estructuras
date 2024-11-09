package com.estructuras.app.Backend.service;

import com.estructuras.app.Backend.models.Leccion;
import com.estructuras.app.Backend.repositories.LeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeccionServices {
    @Autowired
    private LeccionRepository repository;
    public List<Leccion> getAllLessons(){ return repository.findAll(); }

    public List<Leccion> getLessonsByCursoId(Long cursoId) {
        return repository.findByCurso_Id(cursoId);
    }
}
