package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Horario;

@Repository
@Transactional
public class HorarioRepositoryImpl implements IHorarioRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Horario buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Horario> myQuery = this.entityManager
				.createQuery("SELECT h FROM Horario h WHERE h.codigo=:datoCodigo", Horario.class);
		myQuery.setParameter("datoCodigo", codigo);
		return myQuery.getSingleResult();
	}

	@Override
	public void insertar(Horario horario) {
		// TODO Auto-generated method stub
		this.entityManager.persist(horario);
	}

	@Override
	public void actualizar(Horario horario) {
		// TODO Auto-generated method stub
		this.entityManager.merge(horario);
	}

	@Override
	public void actualizarPorCodigo(String codigoActual, String codigoNuevo) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager
				.createQuery("UPDATE Horario h SET h.codigo=:datoCodigo WHERE h.codigo=:datoCondicion");
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
	public Horario buscarPorID(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Horario.class, id);
	}

	@Override
	public List<Horario> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Horario> myQuery = this.entityManager.createQuery("SELECT h FROM Horario h", Horario.class);
		return myQuery.getResultList();
	}

}
