package com.ahumadamob.ies.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Carrera extends BaseEntity {
	private String nombre;
	
	@ManyToOne
	private Resolucion resolucion;
}
