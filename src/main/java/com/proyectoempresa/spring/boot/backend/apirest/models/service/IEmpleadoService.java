package com.proyectoempresa.spring.boot.backend.apirest.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proyectoempresa.spring.boot.backend.apirest.models.entity.Empleado;


public interface IEmpleadoService {
	
	public List<Empleado> findAll();
	
	public Page<Empleado> findAll(Pageable pageable);
	
	public Page<Empleado> findEmpleados(String nombre, String apellido1, String apellido2, Pageable pageable);
	
	public Empleado findById(Long id);
	
	public Empleado save(Empleado empleado);
	
	public void delete(Long id);

}
