package com.jawhara.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the marque database table.
 * 
 */
@Entity
@NamedQuery(name="Marque.findAll", query="SELECT m FROM Marque m")
public class Marque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_marque")
	private Integer idMarque;

	@Column(name="nom_marque")
	private String nomMarque;

	//bi-directional many-to-many association to Produit
	@ManyToMany(mappedBy="marques")
	private List<Produit> produits;

	public Marque() {
	}

	public Integer getIdMarque() {
		return this.idMarque;
	}

	public void setIdMarque(Integer idMarque) {
		this.idMarque = idMarque;
	}

	public String getNomMarque() {
		return this.nomMarque;
	}

	public void setNomMarque(String nomMarque) {
		this.nomMarque = nomMarque;
	}

	public List<Produit> getProduits() {
		return this.produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

}