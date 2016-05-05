package com.jawhara.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the type_produit database table.
 * 
 */
@Entity
@Table(name="type_produit")
@NamedQuery(name="TypeProduit.findAll", query="SELECT t FROM TypeProduit t")
public class TypeProduit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ref_type_produit")
	private Integer refTypeProduit;

	@Column(name="nom_type_produit")
	private String nomTypeProduit;

	//bi-directional many-to-one association to Produit
	@OneToMany(mappedBy="typeProduit")
	private List<Produit> produits;

	public TypeProduit() {
	}

	public Integer getRefTypeProduit() {
		return this.refTypeProduit;
	}

	public void setRefTypeProduit(Integer refTypeProduit) {
		this.refTypeProduit = refTypeProduit;
	}

	public String getNomTypeProduit() {
		return this.nomTypeProduit;
	}

	public void setNomTypeProduit(String nomTypeProduit) {
		this.nomTypeProduit = nomTypeProduit;
	}

	public List<Produit> getProduits() {
		return this.produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public Produit addProduit(Produit produit) {
		getProduits().add(produit);
		produit.setTypeProduit(this);

		return produit;
	}

	public Produit removeProduit(Produit produit) {
		getProduits().remove(produit);
		produit.setTypeProduit(null);

		return produit;
	}

}