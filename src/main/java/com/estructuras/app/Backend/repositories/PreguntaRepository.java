package com.estructuras.app.Backend.repositories;

import com.estructuras.app.Backend.models.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {
    List<Pregunta> findByLeccion_id(Long LeccionId)  ;
}
