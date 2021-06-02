package com.proyectoempresa.spring.boot.backend.apirest.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoempresa.spring.boot.backend.apirest.models.dao.ChatRepository;
import com.proyectoempresa.spring.boot.backend.apirest.models.documents.Mensaje;
import com.proyectoempresa.spring.boot.backend.apirest.service.ChatService;



@Service
public class ChatServiceImpl implements ChatService{
	
	@Autowired
	private ChatRepository chatDao;

	@Override
	public List<Mensaje> obtenerUltimos10Mensajes() {
		return chatDao.findFirst10ByOrderByFechaDesc();
	}

	@Override
	public Mensaje guardar(Mensaje mensaje) {
		return chatDao.save(mensaje);
	}

}