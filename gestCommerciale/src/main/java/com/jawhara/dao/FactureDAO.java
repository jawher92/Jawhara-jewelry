package com.jawhara.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import com.jawhara.entity.Facture;


public class FactureDAO implements DaoInterface<Facture, Integer>{

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
	public void persist(Facture entity) {
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(entity);
		getEntityManager().getTransaction().commit();
	}

	@Override
	public void update(Facture entity) {
		
	}

	@Override
	public Facture findById(Integer id) {
		return null;
	}

	@Override
	public List<Facture> findAll() {
		getEntityManager().getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Facture> factures = getEntityManager().createQuery("select f from Facture f").getResultList();
		
		getEntityManager().getTransaction().commit();
		return factures;
	}

	@Override
	public void deleteAll() {
		
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
