package com.proyectoempresa.spring.boot.backend.apirest.service;


import com.proyectoempresa.spring.boot.backend.apirest.models.entity.Usuario;

public interface IUsuarioService {

	public Usuario findByUsername(String username);
}

