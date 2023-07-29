package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Horario;

public interface IHorarioRepository {

	public Horario buscarPorCodigo(String codigo);

	public void insertar(Horario horario);

	public void actualizar(Horario horario);

	public void actualizarPorCodigo(String codigoActual, String codigoNuevo);

	public void borrar(Integer id);

	public Horario buscarPorID(Integer id);

	public List<Horario> buscarTodos();

}
