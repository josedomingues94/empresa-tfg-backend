package com.proyectoempresa.spring.boot.backend.apirest.models.service.imp;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyectoempresa.spring.boot.backend.apirest.models.dao.IOficinaDao;
import com.proyectoempresa.spring.boot.backend.apirest.models.entity.Empleado;
import com.proyectoempresa.spring.boot.backend.apirest.models.entity.Oficina;
import com.proyectoempresa.spring.boot.backend.apirest.models.service.IOficinaService;



@Service
public class OficinaServiceImp implements IOficinaService{

	@Autowired
	private IOficinaDao oficinaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Oficina> findAll() {
		return (List<Oficina>) oficinaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Oficina> findAll(Pageable pageable) {
		return oficinaDao.findAll(pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Oficina> findOficinas(String nombre, String ciudad, String provincia, Pageable pageable) {
		return oficinaDao.findOficinas(nombre, ciudad, provincia, pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Oficina findById(Long id) {
		return oficinaDao.findById(id).orElse(null);
	}
	
	

	@Override
	@Transactional
	public Oficina save(Oficina oficina) {
		return oficinaDao.save(oficina);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		oficinaDao.deleteById(id);
		
	}

	@Override
	public Oficina findByCiudad(String ciudad) {
		// TODO Auto-generated method stub
		return null;
	}
}

