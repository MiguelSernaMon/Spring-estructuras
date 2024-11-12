package com.estructuras.app.Backend.service;

import com.estructuras.app.Backend.dto.RespuestaXUsuarioDTO;
import com.estructuras.app.Backend.models.Respuesta;
import com.estructuras.app.Backend.models.RespuestaXUsuario;
import com.estructuras.app.Backend.models.Usuario;
import com.estructuras.app.Backend.repositories.RespuestaXUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class RespuestaXUsuarioServices {

    @Autowired
    private RespuestaXUsuarioRepository respuestaRepository;

    @Autowired
    private UsuarioServices usuarioService;

    @Autowired
    private RespuestaServices respuestaService;

    public ResponseEntity<?> sendAnswer(Long userId, Long answerId, Boolean isCorrect) {
        Optional<Usuario> usuarioOptional = usuarioService.getUserById(userId);
        if (usuarioOptional.isEmpty()) {
            return ResponseEntity.status(404).body("Usuario no encontrado");
        }
        Usuario usuario = usuarioOptional.get();

        Optional<Respuesta> respuestaOptional = respuestaService.getRespuestaById(answerId);
        if (respuestaOptional.isEmpty()) {
            return ResponseEntity.status(404).body("Respuesta no encontrada");
        }
        Respuesta respuesta = respuestaOptional.get();

        Optional<RespuestaXUsuario> respUserOptional = respuestaRepository.findByUsuario_IdAndRespuesta_Id(userId, answerId);
        RespuestaXUsuario respUser;

        if (respUserOptional.isPresent()) {
            respUser = respUserOptional.get();

        } else {
            respUser = new RespuestaXUsuario();
            respUser.setUsuario(usuario);
            respUser.setRespuesta(respuesta);
            respUser.setEsCorrecta(isCorrect);
            respUser.setNumeroIntentos(1);
            respUser.setFecha(new Timestamp(System.currentTimeMillis()));
            respuestaRepository.save(respUser);
        }

        // Map entity to DTO
        RespuestaXUsuarioDTO respUserDTO = new RespuestaXUsuarioDTO(
                respUser.getId(),
                respUser.getUsuario(),
                respUser.getRespuesta(),
                respUser.isEsCorrecta(),
                respUser.getNumeroIntentos(),
                respUser.getFecha()
        );

        return ResponseEntity.ok("holaaa");
    }
}
