package com.proyectoempresa.spring.boot.backend.apirest.models.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoempresa.spring.boot.backend.apirest.models.service.ChatService;
import com.proyectoempresa.spring.boot.backend.apirest.models.dao.ChatDao;
import com.proyectoempresa.spring.boot.backend.apirest.models.documents.Mensaje;

@Service
public class ChatServiceImp implements ChatService  {

	@Autowired
	private ChatDao chatDao;
	
	@Override
	public List<Mensaje> obtenerUltimosMensajes() {
		return chatDao.mensajesOrdenadosFechaDesc();
	}

	@Override
	public Mensaje guardar(Mensaje mensaje) {
		return chatDao.save(mensaje);
	}


}
