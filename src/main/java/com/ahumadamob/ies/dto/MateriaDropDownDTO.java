package com.ahumadamob.ies.dto;

public class MateriaDropDownDTO {
	
	private Long id;
	private String nombre;
	
    public MateriaDropDownDTO(Long id, String nombre) { 
        this.id = id;
        this.nombre = nombre;
    }

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}
	


}
