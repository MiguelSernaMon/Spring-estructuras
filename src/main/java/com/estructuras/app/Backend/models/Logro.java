package com.estructuras.app.Backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "logros")
public class Logro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Identificador único de cada logro.

    @Column(name = "nombre", nullable = false)
    private String nombre; // Nombre del logro.

    @Column(name = "descripcion", columnDefinition = "TEXT", nullable = false)
    private String descripcion; // Descripción detallada del logro.

    @Column(name = "imagen_url", nullable = true)
    private String imagenUrl; // URL de la imagen asociada al logro.

    // Constructor vacío (requerido por JPA)
    public Logro() {}

    // Constructor con parámetros
    public Logro(String nombre, String descripcion, String imagenUrl) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagenUrl = imagenUrl;
    }
}