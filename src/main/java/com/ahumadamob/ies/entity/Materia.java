package com.ahumadamob.ies.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Materia extends BaseEntity {
	private String nombre;
	
	@ManyToOne
	private Carrera carrera;
}
