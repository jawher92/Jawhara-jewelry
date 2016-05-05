package com.jawhara.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the achat database table.
 * 
 */
@Entity
@NamedQuery(name="Achat.findAll", query="SELECT a FROM Achat a")
public class Achat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_achat")
	private Integer idAchat;

	@Temporal(TemporalType.DATE)
	@Column(name="date_achat")
	private Date dateAchat;

	//bi-directional many-to-one association to Fournisseur
	@ManyToOne
	@JoinColumn(name="id_fr")
	private Fournisseur fournisseur;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="id_utilisateur")
	private Utilisateur utilisateur;

	//bi-directional many-to-one association to ProduitAchat
	@OneToMany(mappedBy="achat")
	private List<ProduitAchat> produitAchats;

	public Achat() {
	}

	public Integer getIdAchat() {
		return this.idAchat;
	}

	public void setIdAchat(Integer idAchat) {
		this.idAchat = idAchat;
	}

	public Date getDateAchat() {
		return this.dateAchat;
	}

	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}

	public Fournisseur getFournisseur() {
		return this.fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<ProduitAchat> getProduitAchats() {
		return this.produitAchats;
	}

	public void setProduitAchats(List<ProduitAchat> produitAchats) {
		this.produitAchats = produitAchats;
	}

	public ProduitAchat addProduitAchat(ProduitAchat produitAchat) {
		getProduitAchats().add(produitAchat);
		produitAchat.setAchat(this);

		return produitAchat;
	}

	public ProduitAchat removeProduitAchat(ProduitAchat produitAchat) {
		getProduitAchats().remove(produitAchat);
		produitAchat.setAchat(null);

		return produitAchat;
	}

}