package com.proyectoempresa.spring.boot.backend.apirest.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.proyectoempresa.spring.boot.backend.apirest.models.entity.Empleado;
import com.proyectoempresa.spring.boot.backend.apirest.models.entity.Oficina;


public interface IEmpleadoService {
	
	List<Empleado> findAll();
	
	Page<Empleado> findAll(Pageable pageable);
	
	public Page<Empleado> findEmpleadoFiltrado(String nombre, String apellido1, String apellido2, String email, Pageable pageable);
	
	public List<Oficina> findAllOficinas();
	
	public Empleado findByOficinaId(Long id);
	
	
	public Empleado findById(Long id);
	
	public Empleado save(Empleado empleado);
	
	public void delete(Long id);

}
