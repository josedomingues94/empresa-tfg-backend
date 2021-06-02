package com.proyectoempresa.spring.boot.backend.apirest.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoempresa.spring.boot.backend.apirest.models.dao.IChatRepository;
import com.proyectoempresa.spring.boot.backend.apirest.models.documents.Mensaje;
import com.proyectoempresa.spring.boot.backend.apirest.service.IChatService;




@Service
public class ChatServiceImpl implements IChatService{
	
	@Autowired
	private IChatRepository chatDao;

	@Override
	public List<Mensaje> obtenerUltimos10Mensajes() {
		return chatDao.findFirst10ByOrderByFechaDesc();
	}

	@Override
	public Mensaje guardar(Mensaje mensaje) {
		return chatDao.save(mensaje);
	}

}
