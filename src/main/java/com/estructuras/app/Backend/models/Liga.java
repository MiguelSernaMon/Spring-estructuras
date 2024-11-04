package com.estructuras.app.Backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "ligas")
public class Liga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Identificador único de cada liga.

    @Column(name = "nombre", nullable = false)
    private String nombre; // Nombre de la liga.

    @Column(name = "descripcion", columnDefinition = "TEXT", nullable = true)
    private String descripcion; // Descripción detallada de la liga.

    @Column(name = "fecha_inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio; // Fecha de inicio de la liga.

    @Column(name = "fecha_fin", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFin; // Fecha de finalización de la liga.

    // Constructor vacío (requerido por JPA)
    public Liga() {}

    // Constructor con parámetros
    public Liga(String nombre, String descripcion, Date fechaInicio, Date fechaFin) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

}
