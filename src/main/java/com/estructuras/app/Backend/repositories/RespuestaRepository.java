package com.estructuras.app.Backend.repositories;

import com.estructuras.app.Backend.models.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {
    List<Respuesta> findByPregunta_id(Long question_id);
}
