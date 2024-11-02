package com.ahumadamob.ies.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahumadamob.ies.entity.Resolucion;
import com.ahumadamob.ies.repository.ResolucionRepository;
import com.ahumadamob.ies.service.IResolucionService;

@Service
public class ResolucionServiceJpa implements IResolucionService {
	
	@Autowired
	private ResolucionRepository r;	

	@Override
	public List<Resolucion> findAllDefault() {
		return r.findAllDefault();
	}

}
