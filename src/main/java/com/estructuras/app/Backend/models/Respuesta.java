package com.estructuras.app.Backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "respuestas")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Identificador único de cada respuesta.

    @ManyToOne
    @JoinColumn(name = "id_pregunta", nullable = false)
    private Pregunta pregunta; // Clave foránea que referencia el ID de la pregunta.

    @Column(name = "es_correcta", nullable = false)
    private boolean esCorrecta; // Indica si la respuesta es correcta.

    @Column(name = "contenido", nullable = false)
    private String contenido; // Texto de la respuesta.

    @Column(name = "feedback")
    private String feedback; // Mensaje de retroalimentación para el usuario.

    // Constructor vacío (requerido por JPA)
    public Respuesta() {}

    // Constructor con parámetros
    public Respuesta(Pregunta pregunta, boolean esCorrecta, String contenido, String feedback) {
        this.pregunta = pregunta;
        this.esCorrecta = esCorrecta;
        this.contenido = contenido;
        this.feedback = feedback;
    }
}