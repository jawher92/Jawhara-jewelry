package com.jawhara.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.jawhara.entity.TypeProduit;

public class TypeProduitDao implements DaoInterface<TypeProduit, Integer>{
	
	private static final String JPA_UNIT_NAME = "gestCommerciale";
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		if (entityManager == null) {
			entityManager = Persistence.createEntityManagerFactory(
					JPA_UNIT_NAME).createEntityManager();
		}
		return entityManager;
	}

	@Override
	public void persist(TypeProduit entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TypeProduit entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TypeProduit findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TypeProduit> findAll() {
		List<TypeProduit> typeProduits=getEntityManager().createQuery(
				"select t from TypeProduit t").getResultList();
		
		return typeProduits;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	
	
}
