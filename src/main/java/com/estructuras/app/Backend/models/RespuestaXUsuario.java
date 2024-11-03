package com.estructuras.app.Backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "respuesta_x_usuario")
public class RespuestaXUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Identificador único de cada respuesta de un usuario.

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario; // Clave foránea que referencia el ID del usuario.

    @ManyToOne
    @JoinColumn(name = "id_respuesta", nullable = false)
    private Respuesta respuesta; // Clave foránea que referencia la respuesta seleccionada.

    @Column(name = "es_correcta", nullable = false)
    private boolean esCorrecta; // Indica si la respuesta es correcta.

    @Column(name = "numero_intentos", nullable = false)
    private int numeroIntentos; // Número de intentos realizados para responder.

    @Column(name = "fecha", nullable = false)
    private Timestamp fecha; // Fecha y hora de la respuesta.

    // Constructor vacío (requerido por JPA)
    public RespuestaXUsuario() {}

    // Constructor con parámetros
    public RespuestaXUsuario(Usuario usuario, Respuesta respuesta, boolean esCorrecta, int numeroIntentos, Timestamp fecha) {
        this.usuario = usuario;
        this.respuesta = respuesta;
        this.esCorrecta = esCorrecta;
        this.numeroIntentos = numeroIntentos;
        this.fecha = fecha;
    }
}