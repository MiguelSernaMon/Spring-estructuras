package com.estructuras.app.Backend.dto;

import com.estructuras.app.Backend.models.Usuario;
import com.estructuras.app.Backend.models.Respuesta;
import java.sql.Timestamp;

public class RespuestaXUsuarioDTO {
    private Long id;
    private Usuario usuario;
    private Respuesta respuesta;
    private boolean esCorrecta;
    private int numeroIntentos;
    private Timestamp fecha;

    public RespuestaXUsuarioDTO(Long id, Usuario usuario, Respuesta respuesta, boolean esCorrecta, int numeroIntentos, Timestamp fecha) {
        this.id = id;
        this.usuario = usuario;
        this.respuesta = respuesta;
        this.esCorrecta = esCorrecta;
        this.numeroIntentos = numeroIntentos;
        this.fecha = fecha;
    }

    // Getters and Setters
}
