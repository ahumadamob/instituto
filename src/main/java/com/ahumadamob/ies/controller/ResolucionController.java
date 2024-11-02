package com.ahumadamob.ies.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahumadamob.ies.dto.ResolucionDTO;
import com.ahumadamob.ies.dto.ResponseDTO;
import com.ahumadamob.ies.entity.Resolucion;
import com.ahumadamob.ies.service.IResolucionService;
import com.ahumadamob.ies.util.BuildResponse;

@RestController
@RequestMapping(path="/api/v1/resolucion")
public class ResolucionController {
	
	@Autowired
	private IResolucionService resolucionService;
	
	@GetMapping
	public ResponseEntity<ResponseDTO<List<ResolucionDTO>>> getResoluciones(){
		List<Resolucion> all = resolucionService.findAllDefault();
		List<ResolucionDTO> resoluciones = all.stream()
				.map(resolucion -> new ResolucionDTO(resolucion.getId(), resolucion.getNombre()))
				.collect(Collectors.toList());
		return 	!resoluciones.isEmpty() ? BuildResponse.success(resoluciones):
				BuildResponse.notFound("No se encontraron elementos");
	}	

}
