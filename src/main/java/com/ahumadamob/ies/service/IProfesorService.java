package com.ahumadamob.ies.service;

import java.util.List;

import com.ahumadamob.ies.entity.Profesor;

public interface IProfesorService {

	public boolean existById(Long id);
	public boolean existByIdNoDelete(Long id);
	public Profesor save(Profesor profesor);
	public List<Profesor> findAllDefault();
	public void delete(Long id);
	public Profesor findById (Long id);
}
