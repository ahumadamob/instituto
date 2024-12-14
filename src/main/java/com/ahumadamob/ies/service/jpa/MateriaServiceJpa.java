package com.ahumadamob.ies.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahumadamob.ies.dto.MateriaDropDownDTO;
import com.ahumadamob.ies.entity.Materia;
import com.ahumadamob.ies.repository.MateriaRepository;
import com.ahumadamob.ies.service.IMateriaService;

@Service
public class MateriaServiceJpa implements IMateriaService {
	
	@Autowired
	private MateriaRepository r;

	@Override
	public Materia findById(Long id) {
		return r.findById(id).orElse(null);
	}

	@Override
	public Materia save(Materia materia) {
		return r.save(materia);
	}

	@Override
	public void delete(Long id) {
		if(this.exists(id)) {
			Materia materia = this.findById(id);
			materia.setDeleted(true);
			r.save(materia);
		}
	}

	@Override
	public boolean exists(Long id) {
		return (id==null)?false:r.existsById(id);
	}

	@Override
	public List<MateriaDropDownDTO> findByCarreraDropDown(Long carrera_id) {
		return r.findByCarreraDropDown(carrera_id);
	}

}
