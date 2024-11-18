package com.estructuras.app.Backend.dto;

public class UsuarioLigaDTO {
    private Integer ligaId;  // El ID de la liga
    private int puntosLiga;  // Los puntos de la liga

    // Constructor que acepta los valores que necesitamos
    public UsuarioLigaDTO(Integer ligaId, int puntosLiga) {
        this.ligaId = ligaId;
        this.puntosLiga = puntosLiga;
    }

    // Getters y Setters
    public Integer getLigaId() {
        return ligaId;
    }

    public void setLigaId(Integer ligaId) {
        this.ligaId = ligaId;
    }

    public int getPuntosLiga() {
        return puntosLiga;
    }

    public void setPuntosLiga(int puntosLiga) {
        this.puntosLiga = puntosLiga;
    }
}

