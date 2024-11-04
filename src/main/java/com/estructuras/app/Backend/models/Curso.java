package com.estructuras.app.Backend.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Miguel
 */
@Entity
@Getter @Setter
@Table(name = "cursos")
public class Curso {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "nivel", nullable = false)
    private int nivel;
    @Lob
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    private String requisitos;
    
}
