package com.jawhara.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.jawhara.entity.Produit;

public class ProduitDao implements DaoInterface<Produit, Integer>{
	
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
	public void persist(Produit produit) {
		
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(produit);
		getEntityManager().getTransaction().commit();
	}

	@Override
	public void update(Produit produit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produit findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public Produit findByCode(String code) {
		try{
			getEntityManager().getTransaction().begin();
			List<Produit> produits=getEntityManager().createQuery(
				"select p from Produit p WHERE p.codeProduit LIKE :cp")
					.setParameter("cp", code)
					.setMaxResults(1)
					.getResultList();
			getEntityManager().getTransaction().commit();
		
		return produits.get(0);
		
		}catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Produit> findAll() {
	
		getEntityManager().getTransaction().begin();
		List<Produit> produits=getEntityManager().createQuery(
				"select p from Produit p").getResultList();
		getEntityManager().getTransaction().commit();
		return produits;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int delete(int id) {
		int x =0;
		try{
			getEntityManager().getTransaction().begin();
			List<Produit> produits=getEntityManager().createQuery(
					"select p from Produit p WHERE p.refProduit ="+id)
				    .getResultList();
			
			for(Produit produit:produits){
				System.out.println("--------"+produit.getTypeProduit().getNomTypeProduit());
				getEntityManager().remove(produit);
				getEntityManager().getTransaction().commit();
				System.out.println("--------"+produit.getTypeProduit().getNomTypeProduit());
				x++;
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		getEntityManager().getTransaction().commit();
		return x;
	}

}
