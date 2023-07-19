package com.uce.edu.demo.estudiante.service;

import java.util.List;

import com.uce.edu.demo.estudiante.modelo.Horario;

public interface IHorarioService {

	public Horario buscarPorCodigo(String codigo);

	public void guardar(Horario horario);

	public void actualizar(Horario horario);

	public void actualizarPorCodigo(String codigoActual, String codigoNuevo);

	public void borrar(Integer id);

	public Horario buscarPorID(Integer id);

	public List<Horario> buscarTodos();

}
