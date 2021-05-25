package com.proyectoempresa.spring.boot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.proyectoempresa.spring.boot.backend.apirest.models.documents.Mensaje;

public interface ChatDao extends MongoRepository<Mensaje, String> {
	
	public List<Mensaje> mensajesOrdenadosFechaDesc();

}
