package com.ahumadamob.ies.dto;

public class CarreraDTO {
	private Long id;
	private String nombre;
	private String resolucion;
	
	public CarreraDTO(Long id, String nombre, String resolucion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.resolucion = resolucion;
	}
	
	public Long getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getResolucion() {
		return resolucion;
	}

}
