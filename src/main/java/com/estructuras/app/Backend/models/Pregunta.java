package com.estructuras.app.Backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "preguntas")
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Identificador único de cada pregunta.

    @ManyToOne
    @JoinColumn(name = "id_leccion", nullable = false)
    private Leccion leccion; // Relación con la tabla de lecciones.

    @Column(name = "enunciado", nullable = false)
    private String enunciado; // Enunciado o texto de la pregunta.

    @Column(name = "respondida", nullable = false)
    private Boolean respondida;

    @ManyToOne
    @JoinColumn(name = "id_tipo", nullable = false)
    private TipoPregunta tipoPregunta; // Relación con la tabla de tipos de preguntas.

    @ManyToOne
    @JoinColumn(name = "id_dificultad", nullable = false)
    private DificultadPregunta dificultad; // Relación con la tabla de niveles de dificultad.


    // Constructor vacío (requerido por JPA)
    public Pregunta() {}

    // Constructor con parámetros
    public Pregunta(Leccion leccion, String enunciado, TipoPregunta tipoPregunta, DificultadPregunta dificultad) {
        this.leccion = leccion;
        this.enunciado = enunciado;
        this.tipoPregunta = tipoPregunta;
        this.dificultad = dificultad;
    }
}