package com.estructuras.app.Backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tipos_preguntas")
public class TipoPregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Identificador único de cada tipo de pregunta.

    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre; // Nombre del tipo de pregunta.

    // Constructor vacío (requerido por JPA)
    public TipoPregunta() {}

    // Constructor con parámetros
    public TipoPregunta(String nombre) {
        this.nombre = nombre;
    }
}
