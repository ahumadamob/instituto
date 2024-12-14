package com.ahumadamob.ies.service;

import java.util.List;

import com.ahumadamob.ies.dto.MateriaDropDownDTO;
import com.ahumadamob.ies.entity.Materia;

public interface IMateriaService {
	public List<MateriaDropDownDTO> findByCarreraDropDown(Long carrera_id);
	public Materia findById(Long id);
	public Materia save(Materia materia);
	public void delete(Long id);
	public boolean exists(Long id);
	
}
