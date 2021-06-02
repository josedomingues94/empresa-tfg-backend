package com.proyectoempresa.spring.boot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="empleados")
public class Empleado implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false, unique = true)
	private String dni;
	
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false)
	private String nombre;
	
	@NotEmpty(message = "no puede estar vacio")
	private String apellido1;
	
	@NotEmpty(message = "no puede estar vacio")
	private String apellido2;

	@NotEmpty(message = "no puede estar vacio")
	@Email(message = "no es una dirección de correo bien formada")
	@Column(nullable = false, unique = true)
	private String email;
	
	@NotNull(message = "no puede estar vacio")
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;

	private String foto;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "oficina_id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Oficina oficina;
	
	
	

	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}


	



	public String getDni() {
		return dni;
	}





	public void setDni(String dni) {
		this.dni = dni;
	}





	public String getNombre() {
		return nombre;
	}





	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	public String getApellido1() {
		return apellido1;
	}





	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}





	public String getApellido2() {
		return apellido2;
	}





	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public Date getCreateAt() {
		return createAt;
	}





	public void setCreateAt(Date fecha) {
		this.createAt = fecha;
	}





	public String getFoto() {
		return foto;
	}





	public void setFoto(String foto) {
		this.foto = foto;
	}





	




	public Oficina getOficina() {
		return oficina;
	}





	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}










	private static final long serialVersionUID = 1L;

}
