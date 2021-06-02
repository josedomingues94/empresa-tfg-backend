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
import org.springframework.web.multipart.MultipartFile;


import com.proyectoempresa.spring.boot.backend.apirest.models.entity.Empleado;
import com.proyectoempresa.spring.boot.backend.apirest.models.entity.Oficina;
import com.proyectoempresa.spring.boot.backend.apirest.service.IEmpleadoService;
import com.proyectoempresa.spring.boot.backend.apirest.service.IUploadFileService;



@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:4200"})
public class EmpleadoRestController {

	@Autowired
	private IEmpleadoService empleadoService;
	
	@Autowired
	private IUploadFileService uploadService;
	
	private int numeroElementos = 4;
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/empleados/page/{page}")
	public Page<Empleado> getEmpleadoFiltrado(@RequestParam String nombre, @RequestParam String apellido1,
			@RequestParam String apellido2, @RequestParam String email, @PathVariable Integer page) {

		nombre = nombre.equalsIgnoreCase("undefined") ? "%" : nombre;
		apellido1 = apellido1.equalsIgnoreCase("undefined") ? "%" : apellido1;
		apellido2 = apellido2.equalsIgnoreCase("undefined") ? "%" : apellido2;
		email = email.equalsIgnoreCase("undefined") ? "%" : email;

		Pageable pageable = PageRequest.of(page, numeroElementos);
		return this.empleadoService.findEmpleadoFiltrado(nombre, apellido1, apellido2, email, pageable);
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/empleados/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Empleado empleado = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			empleado = empleadoService.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(empleado == null) {
			response.put("mensaje", "El empleado ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Empleado>(empleado, HttpStatus.OK);
	}
	
	@Secured("ROLE_ADMIN")
	@PostMapping("/empleados")
	public ResponseEntity<?> create(@RequestBody Empleado empleado, BindingResult result) {
		Empleado empleadoNuevo = null;
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			empleadoNuevo = empleadoService.save(empleado);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El empleado ha sido creado con éxito!");
		response.put("empleado", empleadoNuevo);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@Secured("ROLE_ADMIN")
	@PutMapping("/empleados/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Empleado empleado, BindingResult result, @PathVariable Long id) {

		Empleado empleadoActual = empleadoService.findById(id);

		Empleado empleadoActualizado = null;

		Map<String, Object> response = new HashMap<>();

		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (empleadoActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el empleado ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			empleadoActual.setDni(empleado.getDni());
			empleadoActual.setNombre(empleado.getNombre());
			empleadoActual.setApellido1(empleado.getApellido1());
			empleadoActual.setApellido2(empleado.getApellido2());
			empleadoActual.setEmail(empleado.getEmail());
			empleadoActual.setCreateAt(empleado.getCreateAt());
			empleadoActual.setOficina(empleado.getOficina());
			

			empleadoActualizado = empleadoService.save(empleadoActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el empleado en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El empleado ha sido actualizado con éxito!");
		response.put("empleado", empleadoActualizado);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@Secured("ROLE_ADMIN")
	@DeleteMapping("/empleados/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			Empleado empleado = empleadoService.findById(id);
			String nombreFotoAnterior = empleado.getFoto();
			
			uploadService.eliminar(nombreFotoAnterior);
			
		    empleadoService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el empleado de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El empleado eliminado con éxito!");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@PostMapping("/empleados/upload")
	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id){
		Map<String, Object> response = new HashMap<>();
		
		Empleado empleado = empleadoService.findById(id);
		
		if(!archivo.isEmpty()) {

			String nombreArchivo = null;
			try {
				nombreArchivo = uploadService.copiar(archivo);
			} catch (IOException e) {
				response.put("mensaje", "Error al subir la imagen del empleado");
				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			String nombreFotoAnterior = empleado.getFoto();
			
			uploadService.eliminar(nombreFotoAnterior);
						
			empleado.setFoto(nombreArchivo);
			
			empleadoService.save(empleado);
			
			response.put("empleado", empleado);
			response.put("mensaje", "Has subido correctamente la imagen: " + nombreArchivo);
			
		}
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/uploads/img/{nombreFoto:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto){

		Resource recurso = null;
		
		try {
			recurso = uploadService.cargar(nombreFoto);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");
		
		return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
	}
	
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/empleados/oficinas")
	public List<Oficina> listarRegiones(){
		return empleadoService.findAllOficinas();
	}
	
}
