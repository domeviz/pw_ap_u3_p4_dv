package com.uce.edu.demo.estudiante.repository;

import com.uce.edu.demo.estudiante.modelo.Materia;

public interface IMateriaRepository {

	public Materia buscarPorCodigo(String codigo);
	
	public void insertar(Materia materia);

}
