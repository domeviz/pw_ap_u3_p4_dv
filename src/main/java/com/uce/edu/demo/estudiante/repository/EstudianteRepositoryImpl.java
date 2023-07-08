package com.uce.edu.demo.estudiante.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.estudiante.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Estudiante buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery=this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.cedula=:datoCedula",Estudiante.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}

}
