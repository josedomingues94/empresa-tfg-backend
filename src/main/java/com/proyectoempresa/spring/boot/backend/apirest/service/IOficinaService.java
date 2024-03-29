package com.proyectoempresa.spring.boot.backend.apirest.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proyectoempresa.spring.boot.backend.apirest.models.entity.Empleado;
import com.proyectoempresa.spring.boot.backend.apirest.models.entity.Oficina;



public interface IOficinaService {
	
	List<Oficina> findAll();
	
	Page<Oficina> findAll(Pageable pageable);
	
	public Page<Oficina> findOficinasFiltradas(String nombre, String ciudad, String provincia, Pageable pageable);
	
	public Oficina findById(Long id);
	
	public Oficina findByCiudad(String ciudad);
	
	public Oficina save(Oficina oficina);
	
	public void delete(Long id);

}