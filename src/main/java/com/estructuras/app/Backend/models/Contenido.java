package com.estructuras.app.Backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "contenidos")
public class Contenido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Identificador único de cada contenido.

    @ManyToOne
    @JoinColumn(name = "id_leccion", nullable = false)
    private Leccion leccion; // Relación con la tabla de lecciones.

    @ManyToOne
    @JoinColumn(name = "tipoContenido", nullable = false)
    private TipoContenido tipoContenido; // Relación con la tabla de tipos de contenido.

    @Column(name = "titulo", nullable = false)
    private String titulo; // Título o nombre del contenido.

    @Lob // Permite texto largo
    @Column(name = "contenido")
    private String contenido; // Contenido principal del elemento.

    // Constructor vacío (requerido por JPA)
    public Contenido() {}

    // Constructor con parámetros
    public Contenido(Leccion leccion, TipoContenido tipoContenido, String titulo, String contenido) {
        this.leccion = leccion;
        this.tipoContenido = tipoContenido;
        this.titulo = titulo;
        this.contenido = contenido;
    }


}
