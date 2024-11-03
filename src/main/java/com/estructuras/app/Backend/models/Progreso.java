/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estructuras.app.Backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 *
 * @author Miguel
 */
@Entity
@Getter
@Setter
public class Progreso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario; // Relación con la tabla de usuarios.

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso; // Relación con la tabla de cursos.

    @ManyToOne
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado estado; // Relación con la tabla de estados.

    @Column(name = "progreso")
    private float progreso; // Porcentaje de avance o completitud del curso.

    @Column(name = "ultima_fecha")
    private Timestamp ultimaFecha; // Fecha y hora de la última actualización del progreso.

}
