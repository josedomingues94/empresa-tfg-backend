package com.proyectoempresa.spring.boot.backend.apirest.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.proyectoempresa.spring.boot.backend.apirest.models.entity.Empleado;
import com.proyectoempresa.spring.boot.backend.apirest.models.entity.Oficina;


public interface IEmpleadoService {
	
	public Page<Empleado> findAll(Pageable pageable);
	
	public Empleado findById(Long id);
	
	public Empleado save(Empleado empleado);
	
	public void delete(Long id);
	
	public List<Oficina> findAllOficinas();

}
