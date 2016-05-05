package com.jawhara.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the produit_facture database table.
 * 
 */
@Entity
@Table(name="produit_facture")
@NamedQuery(name="ProduitFacture.findAll", query="SELECT p FROM ProduitFacture p")
public class ProduitFacture implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProduitFacturePK id;

	@Column(name="qte_vendu")
	private Integer qteVendu;

	@Column(name="raison_remboursement")
	private String raisonRemboursement;

	private Boolean rombourse;

	//bi-directional many-to-one association to Facture
	@MapsId("idFacture")
	@ManyToOne
	@JoinColumn(name="id_facture")
	private Facture facture;

	//bi-directional many-to-one association to Produit
	@MapsId("refProduit")
	@ManyToOne
	@JoinColumn(name="ref_produit")
	private Produit produit;

	public ProduitFacture() {
	}

	public ProduitFacturePK getId() {
		return this.id;
	}

	public void setId(ProduitFacturePK id) {
		this.id = id;
	}

	public Integer getQteVendu() {
		return this.qteVendu;
	}

	public void setQteVendu(Integer qteVendu) {
		this.qteVendu = qteVendu;
	}

	public String getRaisonRemboursement() {
		return this.raisonRemboursement;
	}

	public void setRaisonRemboursement(String raisonRemboursement) {
		this.raisonRemboursement = raisonRemboursement;
	}

	public Boolean getRombourse() {
		return this.rombourse;
	}

	public void setRombourse(Boolean rombourse) {
		this.rombourse = rombourse;
	}

	public Facture getFacture() {
		return this.facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

}