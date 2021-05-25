package com.proyectoempresa.spring.boot.backend.apirest.models.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyectoempresa.spring.boot.backend.apirest.models.entity.Empleado;
import com.proyectoempresa.spring.boot.backend.apirest.models.entity.Oficina;


public interface IOficinaDao extends CrudRepository<Oficina, Integer>, JpaRepository<Oficina, Integer> {

	@Query(value="select * from oficinas where nombre like %?1% " + " or (ciudad like %?2%) or (provincia like %?3%)  "
			, nativeQuery = true)
			public Page <Oficina> findOficinas(String nombre, String ciudad, String provincia, Pageable pageable); 

}
