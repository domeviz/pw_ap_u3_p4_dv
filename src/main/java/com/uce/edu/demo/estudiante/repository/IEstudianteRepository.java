package com.uce.edu.demo.estudiante.repository;

import java.util.List;

import com.uce.edu.demo.estudiante.modelo.Estudiante;

public interface IEstudianteRepository {

	public Estudiante buscarPorCedula(String cedula);
	
	public void insertar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);
	
	public void actualizarPorcedula(String cedulaActual, String cedulaNueva);
	
	public void borrar(Integer id);
	
	public Estudiante buscarPorID(Integer id);
	
	public List<Estudiante> buscarTodos();
	
	public List<Estudiante> buscarTodosPorProvincia(String provincia);
}
