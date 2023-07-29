package com.uce.edu.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IMateriaRepository;
import com.uce.edu.demo.repository.modelo.Materia;
import com.uce.edu.demo.service.to.MateriaTO;

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

	@Override
	public List<MateriaTO> buscarPorCedulaEstudiante(String cedula) {
		// TODO Auto-generated method stub
		List<Materia> lista=this.iMateriaRepository.buscarPorCedulaEstudiante(cedula);
		List<MateriaTO> listaTO=lista.stream().map(materia->this.convertir(materia)).collect(Collectors.toList());
		return listaTO;
	}
	
	private MateriaTO convertir(Materia materia) {
		MateriaTO mat=new MateriaTO();
		mat.setId(materia.getId());
		mat.setNombre(materia.getNombre());
		mat.setNumeroCreditos(materia.getNumeroCreditos());
		return mat;
	}

	@Override
	public MateriaTO buscarId(Integer id) {
		// TODO Auto-generated method stub
		Materia materia=this.iMateriaRepository.buscarId(id);
        return convertir(materia);
	}
}
