package com.uce.edu.demo.estudiante.service;

import com.uce.edu.demo.estudiante.modelo.Estudiante;

public interface IEstudianteService {

	public Estudiante buscarPorCedula(String cedula);
	
	public void guardar(Estudiante estudiante);
}
