package com.ahumadamob.ies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahumadamob.ies.dto.ResponseDTO;
import com.ahumadamob.ies.entity.Profesor;
import com.ahumadamob.ies.service.IProfesorService;
import com.ahumadamob.ies.util.BuildResponse;

@RestController
@RequestMapping(path="/api/v1/profesor")
public class ProfesorController {
	
	@Autowired
	private IProfesorService profesorService;
	
	@PostMapping
	public ResponseEntity<ResponseDTO<Object>> createProfesor(@RequestBody Profesor profesor) {
		if(profesorService.existById(profesor.getId())) {
			return BuildResponse.badRequest(
					"Ya existe un registro para Profesor con el id {0}. El registro no será modificado",
					profesor.getId());			
		}else {
			return BuildResponse.created(profesorService.save(profesor));
		}		
	}
	
	@PutMapping
	public ResponseEntity<ResponseDTO<Object>> updateProfesor(@RequestBody Profesor profesor) {
		if(!profesorService.existById(profesor.getId())) {
			return BuildResponse.badRequest(
					"No existe un registro para Profesor con el id {0}",
					profesor.getId());			
		}else {
			return BuildResponse.modified(profesorService.save(profesor));
		}		
	}
	
	@GetMapping
	public ResponseEntity<ResponseDTO<List<Profesor>>> getAllProfesor() {
		List<Profesor> profesores = profesorService.findAllDefault();
		if (profesores.isEmpty())
			return BuildResponse.notFound("No se encontraron registros");
		else
			return BuildResponse.success(profesores);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDTO<Object>> deleteProfesor(@PathVariable Long id) {
		if(!profesorService.existById(id)) {
			return BuildResponse.badRequest(
					"No existe un registro para Profesor con el id {0}",
					id);				
		}else {
			profesorService.delete(id);
			return BuildResponse.delete("Profesor", id);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO<Profesor>> getProfesorById(@PathVariable Long id) {
		if(!profesorService.existByIdNoDelete(id)) {
			return BuildResponse.badRequest(
					"No existe un registro para Profesor con el id {0}",
					id);				
		}else {
			return BuildResponse.success(profesorService.findById(id));
		}		
	}


}
