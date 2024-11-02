package com.ahumadamob.ies.dto;

public class ResolucionDTO {
    private Long id;
    private String nombre;

    // Constructor
    public ResolucionDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}

