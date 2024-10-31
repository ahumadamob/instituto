package com.ahumadamob.ies.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;

@Entity
public class Asistencia extends BaseEntity {
	@ManyToOne
	private Alumno alumno;
	
	@ManyToOne
	private Clase clase;
	
	@Enumerated
	private EstadoAsistencia estado;

}
