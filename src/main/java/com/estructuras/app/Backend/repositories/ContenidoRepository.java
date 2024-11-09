package com.estructuras.app.Backend.repositories;

import com.estructuras.app.Backend.models.Contenido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContenidoRepository extends JpaRepository<Contenido, Long> {
    List<Contenido> findByLeccion_id(Long leccionId);
}
