package com.ahumadamob.ies.service.jpa;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahumadamob.ies.entity.Profesor;
import com.ahumadamob.ies.repository.ProfesorRepository;
import com.ahumadamob.ies.service.IProfesorService;

@Service
public class ProfesorServiceJpa implements IProfesorService {
	
	@Autowired
	private ProfesorRepository r;

	@Override
	public boolean existById(Long id) {
		return (id == null)? false: r.existsById(id);
	}

	@Override
	public Profesor save(Profesor profesor) {
		return r.save(profesor);
	}

	@Override
	public List<Profesor> findAllDefault() {
		return r.findByIsDeletedFalse();
	}

	@Override
	public void delete(Long id) {
		Profesor profesor = r.findById(id).orElse(null);
		profesor.setDeleted(true);
		profesor.setDeletedAt(LocalDateTime.now());
		r.save(profesor);		
	}

	@Override
	public Profesor findById(Long id) {
		return r.findByIdAndIsDeletedFalse(id).orElse(null);
	}

	@Override
	public boolean existByIdNoDelete(Long id) {
		return r.existsByIdAndIsDeletedFalse(id);
	}
	

}
