package com.estructuras.app.Backend.models;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "logros_x_usuario")
public class LogrosXUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Identificador único de cada registro de logro.

    @ManyToOne // Relación con la entidad Usuario
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario; // Usuario que obtuvo el logro.

    @ManyToOne // Relación con la entidad Logro
    @JoinColumn(name = "id_logro", nullable = false)
    private Logro logro; // Logro obtenido por el usuario.

    @Column(name = "fecha_obtenido", nullable = false)
    @Temporal(TemporalType.DATE) // Especifica que se almacenará solo la fecha.
    private Date fechaObtenido; // Fecha en que se obtuvo el logro.

    // Constructor vacío (requerido por JPA)
    public LogrosXUsuario() {}

    // Constructor con parámetros
    public LogrosXUsuario(Usuario usuario, Logro logro, Date fechaObtenido) {
        this.usuario = usuario;
        this.logro = logro;
        this.fechaObtenido = fechaObtenido;
    }
}
