package com.proyectoempresa.spring.boot.backend.apirest.models.service;

import java.util.List;

import com.proyectoempresa.spring.boot.backend.apirest.models.documents.Mensaje;

public interface ChatService {
	
	public List<Mensaje> obtenerUltimosMensajes();
	public Mensaje guardar(Mensaje mensaje);

}
