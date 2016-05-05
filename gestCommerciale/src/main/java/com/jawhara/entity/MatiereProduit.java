package com.jawhara.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the matiere_produit database table.
 * 
 */
@Entity
@Table(name="matiere_produit")
@NamedQuery(name="MatiereProduit.findAll", query="SELECT m FROM MatiereProduit m")
public class MatiereProduit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ref_matiere_produit")
	private Integer refMatiereProduit;

	@Column(name="nom_matiere")
	private String nomMatiere;

	//bi-directional many-to-many association to Produit
	@ManyToMany(mappedBy="matiereProduits")
	private List<Produit> produits;

	public MatiereProduit() {
	}

	public Integer getRefMatiereProduit() {
		return this.refMatiereProduit;
	}

	public void setRefMatiereProduit(Integer refMatiereProduit) {
		this.refMatiereProduit = refMatiereProduit;
	}

	public String getNomMatiere() {
		return this.nomMatiere;
	}

	public void setNomMatiere(String nomMatiere) {
		this.nomMatiere = nomMatiere;
	}

	public List<Produit> getProduits() {
		return this.produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

}