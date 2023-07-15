package com.uce.edu.demo.estudiante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.estudiante.modelo.Materia;
import com.uce.edu.demo.estudiante.repository.IMateriaRepository;

@Service
public class MateriaServiceImpl implements IMateriaService {

	@Autowired
	private IMateriaRepository iMateriaRepository;
	
	@Override
	public Materia buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.iMateriaRepository.buscarPorCodigo(codigo);
	}

	@Override
	public void guardar(Materia materia) {
		// TODO Auto-generated method stub
		this.iMateriaRepository.insertar(materia);
	}

	@Override
	public void actualizar(Materia materia) {
		// TODO Auto-generated method stub
		this.iMateriaRepository.actualizar(materia);
	}

	@Override
	public void actualizarPorCodigo(String codigoActual, String codigoNuevo) {
		// TODO Auto-generated method stub
		this.iMateriaRepository.actualizarPorCodigo(codigoActual, codigoNuevo);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iMateriaRepository.borrar(id);
	}

	@Override
	public Materia buscarPorID(Integer id) {
		// TODO Auto-generated method stub
		return this.iMateriaRepository.buscarPorID(id);
	}

	@Override
	public List<Materia> buscarTodos() {
		// TODO Auto-generated method stub
		return this.iMateriaRepository.buscarTodos();
	}

	@Override
	public List<Materia> buscarTodosPorCarrera(String carrera) {
		// TODO Auto-generated method stub
		return this.iMateriaRepository.buscarTodosPorCarrera(carrera);
	}
}
