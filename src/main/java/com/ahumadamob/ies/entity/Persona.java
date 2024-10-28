package com.ahumadamob.ies.entity;

import jakarta.persistence.Entity;

@Entity
public class Persona extends BaseEntity {
	private String apellido;
	private String nombre;
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
