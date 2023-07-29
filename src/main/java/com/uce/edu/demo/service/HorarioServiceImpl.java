package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IHorarioRepository;
import com.uce.edu.demo.repository.modelo.Horario;

@Service
public class HorarioServiceImpl implements IHorarioService {

	@Autowired
	private IHorarioRepository iHorarioRepository;

	@Override
	public Horario buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.iHorarioRepository.buscarPorCodigo(codigo);
	}

	@Override
	public void guardar(Horario horario) {
		// TODO Auto-generated method stub
		this.iHorarioRepository.insertar(horario);
	}

	@Override
	public void actualizar(Horario horario) {
		// TODO Auto-generated method stub
		this.iHorarioRepository.actualizar(horario);
	}

	@Override
	public void actualizarPorCodigo(String codigoActual, String codigoNuevo) {
		// TODO Auto-generated method stub
		this.iHorarioRepository.actualizarPorCodigo(codigoActual, codigoNuevo);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iHorarioRepository.borrar(id);
	}

	@Override
	public Horario buscarPorID(Integer id) {
		// TODO Auto-generated method stub
		return this.iHorarioRepository.buscarPorID(id);
	}

	@Override
	public List<Horario> buscarTodos() {
		// TODO Auto-generated method stub
		return this.iHorarioRepository.buscarTodos();
	}

}
