package com.uce.edu.demo.estudiante.service;

import com.uce.edu.demo.estudiante.modelo.Materia;

public interface IMateriaService {

	public Materia buscarPorCodigo(String codigo);
	
	public void guardar(Materia materia);
}
