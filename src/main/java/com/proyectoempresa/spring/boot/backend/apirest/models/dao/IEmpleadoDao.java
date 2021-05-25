package com.proyectoempresa.spring.boot.backend.apirest.models.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyectoempresa.spring.boot.backend.apirest.models.entity.Empleado;


public interface IEmpleadoDao extends CrudRepository<Empleado, Long>,JpaRepository<Empleado, Long>  {

	@Query(value="select * from empleados where nombre like %?1% " + " or (apellido1 like %?2%) or (apellido2 like %?3%)  "
	, nativeQuery = true)
	public Page <Empleado> findEmpleados(String nombre, String apellido1, String apellido2, Pageable pageable); 

	
}
