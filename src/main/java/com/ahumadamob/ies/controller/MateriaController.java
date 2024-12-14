package com.ahumadamob.ies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahumadamob.ies.dto.MateriaDropDownDTO;
import com.ahumadamob.ies.dto.ResponseDTO;
import com.ahumadamob.ies.service.IMateriaService;
import com.ahumadamob.ies.util.BuildResponse;

@RestController
@RequestMapping(path="/api/v1/materia")
public class MateriaController {
	
	@Autowired
	private IMateriaService materiaService;
	
	@GetMapping("/carrera/{carrera_id}")
	public ResponseEntity<ResponseDTO<List<MateriaDropDownDTO>>> getMateriasByCarrera(@PathVariable("carrera_id") Long carrera_id) {
		List<MateriaDropDownDTO> materias = materiaService.findByCarreraDropDown(carrera_id);
		return	(materias.isEmpty()) ? BuildResponse.notFound("No se encontraron materias para la carrera con id {0}", carrera_id):
			BuildResponse.success(materias);
	}

}
