package com.ahumadamob.ies.entity;

import com.ahumadamob.ies.validation.UniqueDni;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@MappedSuperclass
public abstract class Persona extends BaseEntity {
	
    @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$", message = "El apellido solo debe contener letras y espacios")
    @NotBlank(message = "El apellido no puede estar vacío")
	private String apellido;
	
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$", message = "El nombre solo debe contener letras y espacios")
    @NotBlank(message = "El nombre no puede estar vacío")    
    private String nombre;
	
    @NotNull(message = "El DNI no puede ser nulo")
    @Min(value = 10000000, message = "El DNI debe ser mayor o igual a 10.000.000")
    @Max(value = 99999999, message = "El DNI debe ser menor o igual a 99.999.999")    
    @Column(unique = true)
    private Integer dni;
	
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
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	
	
	
}
