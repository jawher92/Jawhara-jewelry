package com.jawhara.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the produit_achat database table.
 * 
 */
@Entity
@Table(name="produit_achat")
@NamedQuery(name="ProduitAchat.findAll", query="SELECT p FROM ProduitAchat p")
public class ProduitAchat implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProduitAchatPK id;

	private double prix;

	@Column(name="qte_achat")
	private Integer qteAchat;

	//bi-directional many-to-one association to Achat
	@MapsId("idAchat")
	@ManyToOne
	@JoinColumn(name="id_achat")
	private Achat achat;

	//bi-directional many-to-one association to Produit
	@MapsId("refProduit")
	@ManyToOne
	@JoinColumn(name="ref_produit")
	private Produit produit;

	public ProduitAchat() {
	}

	public ProduitAchatPK getId() {
		return this.id;
	}

	public void setId(ProduitAchatPK id) {
		this.id = id;
	}


	public double getPrix() {
		return this.prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Integer getQteAchat() {
		return this.qteAchat;
	}

	public void setQteAchat(Integer qteAchat) {
		this.qteAchat = qteAchat;
	}

	public Achat getAchat() {
		return this.achat;
	}

	public void setAchat(Achat achat) {
		this.achat = achat;
	}

	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

}