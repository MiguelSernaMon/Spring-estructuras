package com.estructuras.app.Backend.repositories;

import com.estructuras.app.Backend.models.RespuestaXUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RespuestaXUsuarioRepository extends JpaRepository<RespuestaXUsuario, Long> {
    Optional<RespuestaXUsuario> findByUsuario_IdAndRespuesta_Id(Long usuarioId, Long respuestaId);
}
