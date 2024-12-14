package com.ahumadamob.ies.entity;

import jakarta.persistence.Entity;

@Entity
public class Curso extends BaseEntity {
	private int año;
	private String division;
	
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	
	
}
