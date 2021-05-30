package com.proyectoempresa.spring.boot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.proyectoempresa.spring.boot.backend.apirest.models.documents.Mensaje;


public interface ChatRepository extends MongoRepository<Mensaje, String>{
	
    public List<Mensaje> findFirst10ByOrderByFechaDesc();
}

