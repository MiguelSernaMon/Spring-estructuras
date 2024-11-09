/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estructuras.app.Backend.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Miguel
 */
@Entity
@Getter @Setter
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "email", nullable = false, unique = true)
    private String email;
    
    @Column(name = "password", nullable = false)
    private String password;  // Password field added

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_liga")
    private Liga liga;

    @Column(name = "puntos_liga", nullable = false)
    private int puntosLiga;

    @Column(name = "foto")
    private String foto;

    @Column(name = "biografia")
    private String biografia;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_programa_academico")
//    private ProgramaAcademico programaAcademico;

    @Column(name = "semestre_cursando", nullable = false)
    private byte semestreCursando;  // Corresponding to 'TinyInt'

    @Column(name = "fecha_registro", nullable = false)
    private Timestamp fechaRegistro;
    
    
}
