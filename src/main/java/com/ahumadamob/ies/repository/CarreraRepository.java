package com.ahumadamob.ies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ahumadamob.ies.entity.Carrera;

public interface CarreraRepository extends JpaRepository<Carrera, Long> {
	
	@Query("SELECT c FROM Carrera c JOIN Resolucion r ON c.resolucion.id = r.id WHERE c.isDeleted = false AND c.isDisabled = false AND r.isDeleted = false AND r.isDisabled = false ORDER BY c.nombre ASC")
	public List<Carrera> findAllDefault();

}
