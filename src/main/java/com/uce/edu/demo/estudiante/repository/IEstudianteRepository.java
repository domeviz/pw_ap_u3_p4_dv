package com.uce.edu.demo.estudiante.repository;

import com.uce.edu.demo.estudiante.modelo.Estudiante;

public interface IEstudianteRepository {

	public Estudiante buscarPorCedula(String cedula);
	
	public void insertar(Estudiante estudiante);

}
