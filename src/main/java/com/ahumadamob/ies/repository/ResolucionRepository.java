package com.ahumadamob.ies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ahumadamob.ies.entity.Resolucion;

public interface ResolucionRepository extends JpaRepository<Resolucion, Long> {
	
	@Query("SELECT r FROM Resolucion r WHERE r.isDeleted = false AND r.isDisabled = false ORDER BY r.nombre ASC")
	public List<Resolucion> findAllDefault();


}
