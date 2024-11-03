package com.estructuras.app.Backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "lecciones")
public class Leccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Identificador único de cada lección.

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso; // Relación con la tabla de cursos.

    @Column(name = "numero", nullable = false)
    private int numero; // Número de la lección dentro del curso.

    @Column(name = "nombre", nullable = false)
    private String nombre; // Nombre o título de la lección.

    @Lob // Indica que este campo puede ser un texto largo
    @Column(name = "descripcion")
    private String descripcion; // Descripción detallada del contenido de la lección.

    // Constructor vacío (requerido por JPA)
    public Leccion() {}

    // Constructor con parámetros
    public Leccion(Curso curso, int numero, String nombre, String descripcion) {
        this.curso = curso;
        this.numero = numero;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
