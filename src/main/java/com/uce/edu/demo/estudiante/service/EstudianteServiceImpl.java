package com.uce.edu.demo.estudiante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.estudiante.modelo.Estudiante;
import com.uce.edu.demo.estudiante.repository.IEstudianteRepository;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository iEstudianteRepository;
	
	@Override
	public Estudiante buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.iEstudianteRepository.buscarPorCedula(cedula);
	}

	@Override
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.iEstudianteRepository.insertar(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.iEstudianteRepository.actualizar(estudiante);
	}

	@Override
	public void actualizarPorcedula(String cedulaActual, String cedulaNueva) {
		// TODO Auto-generated method stub
		this.iEstudianteRepository.actualizarPorcedula(cedulaActual, cedulaNueva);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iEstudianteRepository.borrar(id);
	}

	@Override
	public Estudiante buscarPorID(Integer id) {
		// TODO Auto-generated method stub
		return this.iEstudianteRepository.buscarPorID(id);
	}

	@Override
	public List<Estudiante> buscarTodos() {
		// TODO Auto-generated method stub
		return this.iEstudianteRepository.buscarTodos();
	}

	@Override
	public List<Estudiante> buscarTodosPorProvincia(String provincia) {
		// TODO Auto-generated method stub
		return this.iEstudianteRepository.buscarTodosPorProvincia(provincia);
	}
}
