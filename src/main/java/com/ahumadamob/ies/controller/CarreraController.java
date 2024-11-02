package com.ahumadamob.ies.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahumadamob.ies.dto.CarreraDTO;
import com.ahumadamob.ies.dto.ResponseDTO;
import com.ahumadamob.ies.entity.Carrera;
import com.ahumadamob.ies.service.ICarreraService;
import com.ahumadamob.ies.util.BuildResponse;

@RestController
@RequestMapping(path="/api/v1/carrera")
public class CarreraController {
	
	@Autowired
	private ICarreraService carreraService;
	
	@GetMapping
	public ResponseEntity<ResponseDTO<List<CarreraDTO>>> getCarreras(){
		List<Carrera> all = carreraService.findAllDefault();
		List<CarreraDTO> carreras = all.stream()
				.map(carrera -> new CarreraDTO(carrera.getId(), carrera.getNombre(), carrera.getResolucion().getNombre()))
				.collect(Collectors.toList());
		return 	!carreras.isEmpty() ? BuildResponse.success(carreras):
				BuildResponse.notFound("No se encontraron elementos");
	}	

}
