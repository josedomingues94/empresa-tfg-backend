package com.proyectoempresa.spring.boot.backend.apirest.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoempresa.spring.boot.backend.apirest.models.entity.Empleado;
import com.proyectoempresa.spring.boot.backend.apirest.models.entity.Oficina;
import com.proyectoempresa.spring.boot.backend.apirest.models.service.IOficinaService;



@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"*"})
public class OficinaRestController {
	
	@Autowired
	private IOficinaService oficinaService;
	
	private int numeroElementos = 4;
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/oficinas/page/{page}")
	public Page<Oficina> getOficinasFiltradas(@RequestParam String nombre, @RequestParam String ciudad,
			@RequestParam String provincia, @PathVariable Integer page) {

		nombre = nombre.equalsIgnoreCase("undefined") ? "%" : nombre;
		ciudad = ciudad.equalsIgnoreCase("undefined") ? "%" : ciudad;
		provincia = provincia.equalsIgnoreCase("undefined") ? "%" : provincia;

		Pageable pageable = PageRequest.of(page, numeroElementos);
		return this.oficinaService.findOficinasFiltradas(nombre, ciudad, provincia, pageable);
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/oficinas/{id}")
	public ResponseEntity<?> show(@PathVariable Long id){
		Oficina oficina = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			oficina = oficinaService.findById(id);
		}
		catch(DataAccessException e) {
			response.put("mensaje","Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(oficina == null) {
			response.put("mensaje", "La oficina con ID: " + id + " no existe en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Oficina>(oficina, HttpStatus.OK);
	}
	
	@Secured("ROLE_ADMIN")
	@PostMapping("/oficinas")
	public ResponseEntity<?> create(@RequestBody Oficina oficina, BindingResult result){
		Oficina oficinaNueva = null;
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			oficinaNueva = oficinaService.save(oficina);
		}
		catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La oficina ha sido creada con exito");
		response.put("oficina", oficinaNueva);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@Secured("ROLE_ADMIN")
	@PutMapping("/oficinas/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Oficina oficina, BindingResult result, @PathVariable Long id){
		
		Oficina oficinaActual = oficinaService.findById(id);
		Oficina oficinaActualizada = null;
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String ,Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if(oficina == null) {
			response.put("mensaje", "Error no se pudieron editar los datos de la oficina con ID:" 
					+ id + " no existe en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			oficinaActual.setNombre(oficina.getNombre());
			oficinaActual.setDireccion(oficina.getDireccion());
			oficinaActual.setProvincia(oficina.getProvincia());
			oficinaActual.setCiudad(oficina.getCiudad());
			
			oficinaActualizada = oficinaService.save(oficinaActual);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al acutalizar la oficina en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La oficina ha sido acutalizada con exito");
		response.put("oficina", oficinaActualizada);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@Secured("ROLE_ADMIN")
	@DeleteMapping("/oficinas/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			oficinaService.delete(id);
		}
		catch(DataAccessException e) {
			response.put("mensaje", "Error al eliminar la oficina de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La oficina fue eliminada con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);	
	}

}
