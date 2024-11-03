package com.estructuras.app.Backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "dificultades_preguntas")
public class DificultadPregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Identificador único de cada nivel de dificultad.

    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre; // Nombre del nivel de dificultad.

    // Constructor vacío (requerido por JPA)
    public DificultadPregunta() {}

    // Constructor con parámetros
    public DificultadPregunta(String nombre) {
        this.nombre = nombre;
    }
}
