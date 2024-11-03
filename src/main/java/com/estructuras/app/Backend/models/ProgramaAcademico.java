package com.estructuras.app.Backend.models;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "programas_academicos")
public class ProgramaAcademico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Identificador único de cada programa académico.

    @Column(name = "nombre", nullable = false)
    private String nombre; // Nombre del programa académico.

    // Constructor vacío (requerido por JPA)
    public ProgramaAcademico() {}

    // Constructor con parámetros
    public ProgramaAcademico(String nombre) {
        this.nombre = nombre;
    }

}