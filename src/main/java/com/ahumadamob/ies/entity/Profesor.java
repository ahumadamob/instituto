package com.ahumadamob.ies.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Profesor extends BaseEntity {
	@ManyToOne
	private Persona persona;
}
