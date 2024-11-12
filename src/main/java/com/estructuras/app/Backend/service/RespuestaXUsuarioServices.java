package com.estructuras.app.Backend.service;

import com.estructuras.app.Backend.dto.RespuestaXUsuarioDTO;
import com.estructuras.app.Backend.models.Liga;
import com.estructuras.app.Backend.models.Respuesta;
import com.estructuras.app.Backend.models.RespuestaXUsuario;
import com.estructuras.app.Backend.models.Usuario;
import com.estructuras.app.Backend.repositories.RespuestaXUsuarioRepository;
import com.estructuras.app.Backend.repositories.UsuarioRepository;
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

    @Autowired LigaServices ligaServices;
    @Autowired
    private UsuarioRepository usuarioRepository;


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
            respUser.setNumeroIntentos(respUser.getNumeroIntentos() + 1);
            respuestaRepository.save(respUser);

        } else {

            if(isCorrect){
                usuario.setPuntosLiga(usuario.getPuntosLiga() + 10);
                if (usuario.getPuntosLiga() == 70) {
                    Optional<Liga> liga = ligaServices.getLigaById(2);
                    Liga actualLiga = liga.get();
                    usuario.setLiga(actualLiga);

                }else if (usuario.getPuntosLiga() == 100) {
                    Optional<Liga> liga = ligaServices.getLigaById(3);
                    Liga actualLiga = liga.get();
                    usuario.setLiga(actualLiga);
                }
                usuarioRepository.save(usuario);

            }

            respUser = new RespuestaXUsuario();
            respUser.setUsuario(usuario);
            respUser.setRespuesta(respuesta);
            respUser.setEsCorrecta(isCorrect);
            respUser.setNumeroIntentos(1);
            respUser.setFecha(new Timestamp(System.currentTimeMillis()));
            respuestaRepository.save(respUser);
        }
        return ResponseEntity.ok("answer send");
    }
}
