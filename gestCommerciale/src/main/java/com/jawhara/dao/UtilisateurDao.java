package com.jawhara.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.jawhara.entity.Produit;
import com.jawhara.entity.Utilisateur;

public class UtilisateurDao implements DaoInterface<Utilisateur, Integer>{
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
	public void persist(Utilisateur entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Utilisateur entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utilisateur findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Utilisateur findByLoginMp(String login, String mdp){
		try{
		List<Utilisateur> utilisateurs=getEntityManager().createQuery(
			"select u from Utilisateur u WHERE u.loginUtilisateur LIKE :l AND u.mdpUtilisateur LIKE :m")
				.setParameter("l", login)
				.setParameter("m", mdp)
			    .setMaxResults(1)
			    .getResultList();
		
		return utilisateurs.get(0);
		
		}catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Utilisateur> findAll() {
		List<Utilisateur> utilisateurs=getEntityManager().createQuery(
			"select u from Utilisateur u")
			    .getResultList();
		
		return utilisateurs;
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
