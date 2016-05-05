
package com.jawhara.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import com.jawhara.entity.Fournisseur;


public class FournisseurDao implements DaoInterface<Fournisseur, Integer>{
	
	private static final String JPA_UNIT_NAME = "gestCommerciale";
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		if (entityManager == null) {
			entityManager = Persistence.createEntityManagerFactory(
					JPA_UNIT_NAME).createEntityManager();
		}
		return entityManager;
	}
	
//	public void affiche() {
//		List<Fournisseur> fournisseurs = getEntityManager().createQuery(
//				"select f from Fournisseur f").getResultList();
//		
//		for (Fournisseur fournisseur : fournisseurs) {
//			System.out.println(fournisseur.getNomFr());
//		}
		
//		getEntityManager().getTransaction().begin();
//		Hotel h =new Hotel();
//		h.setNumho(10);h.setNomho("hannibal");
//		h.setVilleho("sousse");h.setNbetoilesho(5);h.setRueadrho("rue1");
//		getEntityManager().persist(h);
//		getEntityManager().getTransaction().commit();
		
//	}

	@Override
	public void persist(Fournisseur fournisseur) {
		
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(fournisseur);
		getEntityManager().getTransaction().commit();
		
	}

	@Override
	public void update(Fournisseur entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Fournisseur findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean exist(Fournisseur fournisseur){ // nomFr et adrFr
		
		try{
			getEntityManager().getTransaction().begin();
			@SuppressWarnings("unchecked")
			List<Fournisseur> fns = getEntityManager().createQuery("select f from Fournisseur f where f.nomFr LIKE :nom and f.adrFr LIKE :adr")
					.setParameter("nom", fournisseur.getNomFr()).setParameter("adr", fournisseur.getAdrFr())
					.setMaxResults(1)
					.getResultList();
			getEntityManager().getTransaction().commit();
		
		if(fns.get(0) != null)
			return true;
		else 
			return false; 
		
		}catch (Exception e) {
			return false;
		}
	}
	
	
	@Override
	public List<Fournisseur> findAll() {
		getEntityManager().getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Fournisseur> fournisseurs = getEntityManager().createQuery("select f from Fournisseur f").getResultList();
		
//		for (Fournisseur fournisseur : fournisseurs) {
//			System.out.println(fournisseur.getNomFr());
//		}
		getEntityManager().getTransaction().commit();
		return fournisseurs;
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
