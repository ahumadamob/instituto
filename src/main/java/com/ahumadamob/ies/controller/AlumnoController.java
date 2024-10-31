package com.ahumadamob.ies.controller;

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

import com.ahumadamob.ies.service.IAlumnoService;
import com.ahumadamob.ies.util.BuildResponse;
import com.ahumadamob.ies.dto.ResponseDTO;
import com.ahumadamob.ies.entity.Alumno;

@RestController
@RequestMapping(path="/api/v1/alumno")
public class AlumnoController {

	@Autowired
	private IAlumnoService alumnoService;
	
	@GetMapping("{id}")
	public ResponseEntity<ResponseDTO<Alumno>> getAlumnoById(@PathVariable("id") Long id){
		return	alumnoService.existsById(id)? BuildResponse.success(alumnoService.getById(id)):
				BuildResponse.notFound("No se encontró el alumno con id {0}.", id);
	}
	
	@PostMapping
	public ResponseEntity<ResponseDTO<Alumno>> createAlumno(@RequestBody Alumno alumno){
		return	!alumnoService.existsById(alumno.getId())? BuildResponse.created(
					alumnoService.save(alumno), "Alumno creado correctamente"):
				BuildResponse.badRequest("Ya existe el alumno con id {0}.", alumno.getId());
	}
	
	@PutMapping
	public ResponseEntity<ResponseDTO<Alumno>> updateAlumno(@RequestBody Alumno alumno){
		return	alumnoService.existsById(alumno.getId())? BuildResponse.success(
					alumnoService.save(alumno), "Alumno modificado correctamente"):
				BuildResponse.badRequest("No existe el alumno con id {0}.", alumno.getId());
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<ResponseDTO<Object>> deleteAlumno(@PathVariable("id") Long id){
		if(alumnoService.existsById(id)) {
			alumnoService.deleteById(id);
			return BuildResponse.success("Alumno eliminado correctamente.");
		}else {
			return BuildResponse.badRequest("No existe el alumno con id {0}.", id);
		}				
	}
}
