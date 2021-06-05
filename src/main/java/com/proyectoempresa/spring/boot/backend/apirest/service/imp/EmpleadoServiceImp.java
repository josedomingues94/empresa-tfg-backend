package com.proyectoempresa.spring.boot.backend.apirest.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyectoempresa.spring.boot.backend.apirest.models.dao.IEmpleadoDao;

import com.proyectoempresa.spring.boot.backend.apirest.models.entity.Empleado;
import com.proyectoempresa.spring.boot.backend.apirest.models.entity.Oficina;
import com.proyectoempresa.spring.boot.backend.apirest.service.IEmpleadoService;


@Service
public class EmpleadoServiceImp implements IEmpleadoService {

	@Autowired
	private IEmpleadoDao empleadoDao;
	
	@Override
	@Transactional(readOnly = true)
	public Page<Empleado> findAll(Pageable pageable) {
		return empleadoDao.findAll(pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Empleado findById(Long id) {
		return empleadoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Empleado save(Empleado empleado) {
		return empleadoDao.save(empleado);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		empleadoDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Oficina> findAllOficinas() {
		return empleadoDao.findAllOficinas();
	}

	

}
