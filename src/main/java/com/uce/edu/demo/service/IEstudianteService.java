package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.service.to.EstudianteTO;

public interface IEstudianteService {

	public Estudiante buscarPorCedula(String cedula);
	
	public void guardar(Estudiante estudiante);
	
	public void actualizar(Estudiante estudiante);
	
	public void actualizarPorcedula(String cedulaActual, String cedulaNueva);
	
	public void borrar(Integer id);
	
	public Estudiante buscarPorID(Integer id);
	
	public List<EstudianteTO> buscarTodos();
	
	public List<Estudiante> buscarTodos2();
	
	public List<Estudiante> buscarTodosPorProvincia(String provincia);
	
	public List<EstudianteTO> buscarTodosProvQuemada();
}