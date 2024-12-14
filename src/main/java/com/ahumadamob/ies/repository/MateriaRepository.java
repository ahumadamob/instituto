package com.ahumadamob.ies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ahumadamob.ies.dto.MateriaDropDownDTO;
import com.ahumadamob.ies.entity.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Long> {
	
    @Query(
    "SELECT new com.ahumadamob.ies.dto.MateriaDropDownDTO(m.id, m.nombre) " +
    "FROM Materia m JOIN m.carrera c " +
    "JOIN c.resolucion r " +
    "WHERE m.carrera.id = :carreraId " +
    "AND m.isDeleted = false AND m.isDisabled = false " +
    "AND c.isDeleted = false AND c.isDisabled = false " +
    "AND r.isDeleted = false AND r.isDisabled = false " +
    "ORDER BY m.nombre ASC, c.nombre ASC"
    )
	List<MateriaDropDownDTO>findByCarreraDropDown(Long carreraId);

}
