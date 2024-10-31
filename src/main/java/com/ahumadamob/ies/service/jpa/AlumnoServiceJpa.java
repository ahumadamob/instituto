package com.ahumadamob.ies.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahumadamob.ies.entity.Alumno;
import com.ahumadamob.ies.exception.DuplicateDniException;
import com.ahumadamob.ies.repository.AlumnoRepository;
import com.ahumadamob.ies.service.IAlumnoService;

@Service
public class AlumnoServiceJpa implements IAlumnoService {
	
	@Autowired
	private AlumnoRepository r;

	@Override
	public Alumno save(Alumno alumno) {
	    if (alumno.getDni() != null && existsByDni(alumno.getDni())) {
	        throw new DuplicateDniException("El DNI " + alumno.getDni() + " ya está registrado.");
	    }
	    return r.save(alumno);
	}

	@Override
	public Alumno getById(Long id) {
		return r.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		r.deleteById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return (id == null)?false:r.existsById(id);
	}

	@Override
	public boolean existsByDni(Integer dni) {
		return r.existsByDni(dni);
	}

}
