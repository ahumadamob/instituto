package com.ahumadamob.ies.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Clase extends BaseEntity {
	@ManyToOne
	private Materia materia;
	
	@ManyToOne
	private Curso curso;
	
	@ManyToOne
	private CicloLectivo cicloLectivo;
	
	@ManyToOne
	private Profesor profesor;
}
