package com.estructuras.app.Backend.repositories;

import com.estructuras.app.Backend.models.Leccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeccionRepository extends JpaRepository<Leccion, Long> {
    List<Leccion> findByCurso_Id(Long cursoId);
}
