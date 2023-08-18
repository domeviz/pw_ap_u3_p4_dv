package com.uce.edu.demo.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="materia")
public class Materia {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_materia")
	@SequenceGenerator(name = "seq_materia",sequenceName = "seq_materia", allocationSize = 1)
	@Column(name="id")
	private Integer id;
	@Column(name="codigo")
	private String codigo;
	@Column(name="nombre")
	private String nombre;
	@Column(name="carrera")
	private String carrera;
	@Column(name="creditos")
	private Integer numeroCreditos;
	
	@ManyToOne
	@JoinColumn(name = "mate_id_estudiante")
	private Estudiante estudiante;

	@Override
	public String toString() {
		return "Materia [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + "]";
	}

	//SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public Integer getNumeroCreditos() {
		return numeroCreditos;
	}

	public void setNumeroCreditos(Integer numeroCreditos) {
		this.numeroCreditos = numeroCreditos;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	
}
