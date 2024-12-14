package com.ahumadamob.ies.entity;

import jakarta.persistence.Entity;

@Entity
public class CicloLectivo extends BaseEntity {
	private int año;

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}
	
	
}
