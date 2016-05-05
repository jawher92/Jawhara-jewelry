package com.jawhara.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the disponible database table.
 * 
 */
@Entity
@NamedQuery(name="Disponible.findAll", query="SELECT d FROM Disponible d")
public class Disponible implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DisponiblePK id;

	@Column(name="qte_dispo")
	private Integer qteDispo;

	//bi-directional many-to-one association to Agence
	@MapsId("numAgence")
	@ManyToOne
	@JoinColumn(name="num_agence")
	private Agence agence;

	//bi-directional many-to-one association to Produit
	@MapsId("refProduit")
	@ManyToOne
	@JoinColumn(name="ref_produit")
	private Produit produit;

	public Disponible() {
	}

	public DisponiblePK getId() {
		return this.id;
	}

	public void setId(DisponiblePK id) {
		this.id = id;
	}

	public Integer getQteDispo() {
		return this.qteDispo;
	}

	public void setQteDispo(Integer qteDispo) {
		this.qteDispo = qteDispo;
	}

	public Agence getAgence() {
		return this.agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

}