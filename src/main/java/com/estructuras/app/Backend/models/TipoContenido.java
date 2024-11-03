package com.estructuras.app.Backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tipos_contenido")
public class TipoContenido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Identificador único del tipo de contenido.

    @Column(name = "nombre", nullable = false)
    private String nombre; // Nombre del tipo de contenido (ej. texto, video, imagen).

    // Constructor vacío (requerido por JPA)
    public TipoContenido() {}

    // Constructor con parámetros
    public TipoContenido(String nombre) {
        this.nombre = nombre;
    }

}