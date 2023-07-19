package com.uce.edu.demo.estudiante.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "horario")
public class Horario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_horario")
	@SequenceGenerator(name = "seq_horario", sequenceName = "seq_horario", allocationSize = 1)
	@Column(name = "id")
	private Integer id;
	@Column(name = "codigo")
	private String codigo;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "horas")
	private Integer horas;

	// GET Y SET
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

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	@Override
	public String toString() {
		return "Horario [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", horas=" + horas + "]";
	}

}
