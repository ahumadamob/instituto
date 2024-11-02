package com.ahumadamob.ies.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahumadamob.ies.entity.Carrera;
import com.ahumadamob.ies.repository.CarreraRepository;
import com.ahumadamob.ies.service.ICarreraService;

@Service
public class CarreraService implements ICarreraService {

	@Autowired
	private CarreraRepository r;
	
	@Override
	public List<Carrera> findAllDefault() {
		return r.findAllDefault();
	}

}
