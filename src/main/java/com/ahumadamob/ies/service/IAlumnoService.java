package com.ahumadamob.ies.service;

import com.ahumadamob.ies.entity.Alumno;

public interface IAlumnoService {
	
	public Alumno save(Alumno alumno);
	public Alumno getById(Long id);
	public void deleteById(Long id);
	public boolean existsById(Long id);

}
