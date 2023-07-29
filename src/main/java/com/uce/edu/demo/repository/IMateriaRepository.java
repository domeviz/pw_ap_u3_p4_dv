package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Materia;
import com.uce.edu.demo.service.to.MateriaTO;

public interface IMateriaRepository {

	public Materia buscarPorCodigo(String codigo);
	
	public void insertar(Materia materia);
	
	public void actualizar(Materia materia);

	public void actualizarPorCodigo(String codigoActual, String codigoNuevo);

	public void borrar(Integer id);

	public Materia buscarPorID(Integer id);

	public List<Materia> buscarTodos();

	public List<Materia> buscarTodosPorCarrera(String carrera);
	
	public List<Materia> buscarPorCedulaEstudiante(String cedula);
	
	public Materia buscarId(Integer id);

}
