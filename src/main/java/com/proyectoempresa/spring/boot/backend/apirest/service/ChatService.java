package com.proyectoempresa.spring.boot.backend.apirest.service;

import java.util.List;

import com.proyectoempresa.spring.boot.backend.apirest.models.documents.Mensaje;


public interface ChatService {

	public List<Mensaje> obtenerUltimos10Mensajes();
	public Mensaje guardar(Mensaje mensaje);
}
