package com.uce.edu.demo.estudiante.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.estudiante.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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

}
