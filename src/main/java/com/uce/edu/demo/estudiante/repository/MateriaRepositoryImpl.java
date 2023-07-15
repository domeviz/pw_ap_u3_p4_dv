package com.uce.edu.demo.estudiante.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.estudiante.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Materia buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Materia> myQuery=this.entityManager.createQuery("SELECT m FROM Materia m WHERE m.codigo=:datoCodigo",Materia.class);
		myQuery.setParameter("datoCodigo", codigo);
		return myQuery.getSingleResult();
	}

	@Override
	public void insertar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(materia);
	}

	@Override
	public void actualizar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.merge(materia);
	}

	@Override
	public void actualizarPorCodigo(String codigoActual, String codigoNuevo) {
		// TODO Auto-generated method stub
		Query myQuery=this.entityManager.createQuery("UPDATE Materia m SET m.codigo=:datoCodigo WHERE m.codigo=:datoCondicion");
		myQuery.setParameter("datoCodigo", codigoNuevo);
		myQuery.setParameter("datoCondicion", codigoActual);
		myQuery.executeUpdate();
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarPorID(id));
	}

	@Override
	public Materia buscarPorID(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Materia.class, id);
	}

	@Override
	public List<Materia> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Materia> myQuery = this.entityManager.createQuery("SELECT m FROM Materia m", Materia.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Materia> buscarTodosPorCarrera(String carrera) {
		// TODO Auto-generated method stub
		TypedQuery<Materia> myQuery = this.entityManager.createQuery("SELECT m FROM Materia m WHERE m.carrera=:datoCarrera", Materia.class);
		myQuery.setParameter("datoCarrera", carrera);
		return myQuery.getResultList();
	}

}
