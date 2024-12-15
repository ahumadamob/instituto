package com.ahumadamob.ies.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahumadamob.ies.entity.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

	public List<Profesor> findByIsDeletedFalse();	
	public Optional<Profesor> findByIdAndIsDeletedFalse(Long id);
	public boolean existsByIdAndIsDeletedFalse(Long id);

}

